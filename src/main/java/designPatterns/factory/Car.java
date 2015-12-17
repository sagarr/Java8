package designPatterns.factory;

import java.awt.Color;

/**
 * @author rohankar
 */
public class Car implements Vehicle {

    private final Color color;

    public Car(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
