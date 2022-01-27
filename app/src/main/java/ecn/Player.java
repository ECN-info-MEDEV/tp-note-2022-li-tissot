package ecn;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {

    @Getter
    private Color color;

    @Getter
    String name;

}
