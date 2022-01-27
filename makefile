MAX_MAP_COUNT := $(shell sysctl vm.max_map_count)

h help default:
	@echo "Use : make [action]" \
		&& echo "Actions:" \
		&& echo " → sonar_up (alias su): starts sonarqube server on http://localhost:9000" \
		&& echo " → sonar_down (alias sd): shutdown the sonarqube server" \
		&& echo " → get_sonar_token (alias gst): get a sonarqube token" \
		&& echo " → help (alias h, or nothing)": get this help message

su sonar_up:
ifneq ($(MAX_MAP_COUNT), vm.max_map_count = 262144)
	@echo "We need to set vm.max_map_count to 262144 (this change is not persistent over reboot)"
	@sudo sysctl -w vm.max_map_count=262144
endif
	@docker-compose up -d

sd sonar_down:
	@docker-compose down

gst get_sonar_token:
	@curl -X POST -u admin:$(or $(subst get_sonar_token ,,$(subst gst ,,$(MAKECMDGOALS))), admin) -F "name=`uuidgen`" http://localhost:9000/api/user_tokens/generate
	@echo
