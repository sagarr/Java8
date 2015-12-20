package designPatterns.builder;

/**
 * @author rohankar
 */
public class BuilderMain {

    public static void main(final String[] args) {
        final VehicleFactory factory = VehicleFactory.factory(builder -> {
            builder.register("motor", Motor::new);
            builder.register("car", Car::new);
        });
        final Vehicle vehicle = factory.create("motor");
        System.out.println(vehicle);
    }

}
