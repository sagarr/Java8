package designPatterns.factory;

/**
 * @author rohankar
 */
@FunctionalInterface
public interface VehicleFactory {

    public Vehicle create();
}
