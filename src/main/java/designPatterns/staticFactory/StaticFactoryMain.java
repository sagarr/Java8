package designPatterns.staticFactory;

/**
 * @author rohankar
 */
public class StaticFactoryMain {

    public static void main(final String[] args) {
        final VehicleFactory vehicleFactory = new VehicleFactory();
        vehicleFactory.register("car", Car::new);
        // for singleton
        final Motor singleton = new Motor();
        vehicleFactory.register("motor", () -> singleton);

        System.out.println(vehicleFactory.create("car"));
        System.out.println(vehicleFactory.create("car"));
        System.out.println(vehicleFactory.create("motor"));
        System.out.println(vehicleFactory.create("motor"));
    }

}
