package designPatterns.factory;

import java.awt.Color;

/**
 * @author rohankar
 */
public class Motor implements Vehicle {

    private final Color color;

    public Motor(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
