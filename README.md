# DS Gen Li & Jean Tissot

## Instructions of use

NB: all the `gradle` commands can be replaced by a `./gradlew` one if you don't have gradle on your computer.

- `gradle run` to run the project
- `gradle test` to run the tests
- `gradle openJavadoc` to generate and open the javadoc (`gradle javadoc` to only generate the javadoc)
- `gradle sonarqube` to run a sonarqube scan
- `gradle build` to generate the jar, run the tests and start a sonarqube scan

Before runing a sonarqube scan you need to start a sonarqube server and set some properties in the _gradle.properties_ file (See Sonarqube server part below).

## Sonarqube server

### Integrated sonarqube server

You can start a sonarqube server with `gradle sonarUp` (you need to have docker-compose installed on your computer).  
**Warning!** Before starting sonarqube server you need to set the _wm.max_map_count_ host parameter to 262144 (this change is not persistent over reboot):

- On linux `sudo sysctl -w vm.max_map_count=262144`
- On Mac with Docker toolbox `docker-machine ssh`, `sudo sysctl -w vm.max_map_count=262144` and `exit`
- On Mac with Docker for Mac `screen ~/Library/Containers/com.docker.docker/Data/vms/0/tty` and `sysctl -w vm.max_map_count=262144`
- On Windows `wsl -d docker-desktop` and `sysctl -w vm.max_map_count=262144`

On Linux you can avoid that by simply running `make sonar_up` (or `make su`) which set the host parameter if needed and starts the sonarqube server.

The first time you start the sonarqube server, you need to get a sonarqube token (with `make get_sonar_token` or `make gst`) and to put it in the gradle.properties file.  
**Warning!** If you changed the sonarqube default password (in the web interface) you need to pass it in argument to the make command (for example `make gst passwd`).

To shutdown the sonarqube server, run `gradle sonarDown` (you can also use `make sonar_down` or `make sd`).

To access sonarqube scan resutls you need to go to http://localhost:9000. Default credentials are `admin` - `admin`.

### Other sonarqube server

If you choose to use another sonarqube server, you should set url and token in the _gradle.properties_

## Q-A

→ to complete
