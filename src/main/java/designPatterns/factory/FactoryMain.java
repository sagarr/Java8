package designPatterns.factory;

import java.awt.Color;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rohankar
 */
public class FactoryMain {

    private static List<Vehicle> create(final VehicleFactory vehicleFactory) {
        return IntStream.range(0, 5).mapToObj(i -> vehicleFactory.create()).collect(Collectors.toList());
    }

    // ----------- Java 8 -------------
    /*
     * with Java 8 predefined interface.
     */

    private static <T, R> Supplier<R> partial(final Function<T, R> function, final T color) {
        return () -> function.apply(color);
    }

    private static List<Vehicle> create2(final Supplier<Vehicle> vehicleFactory) {
        return IntStream.range(0, 5).mapToObj(i -> vehicleFactory.get()).collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    public static void main(final String[] args) {
        final VehicleFactory redMotorFactory = () -> new Motor(Color.RED);
        final VehicleFactory greenCarFactory = () -> new Car(Color.GREEN);

        final List<Vehicle> greenCars = create(greenCarFactory);
        System.out.println(greenCars);

        /* no factory required */
        final List<Vehicle> greenCars2 = create2(partial(Car::new, Color.RED));
        System.out.println(greenCars2);
    }

}
