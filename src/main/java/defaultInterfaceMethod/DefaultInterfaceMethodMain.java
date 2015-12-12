package defaultInterfaceMethod;

interface Vehicle {

    default void start() {
        System.out.println("Vehicle::start");
    }

    default void stop() {
        System.out.println("Vehicle::stop");
    }

}

class Bike implements Vehicle {
    // Rule 1 - by inheritence
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car::start"); // Rule 2 - most specific implementation
    }

    @Override
    public void stop() {
        System.out.println("Car::stop");
    }
}

class IndianCarVehicle implements Vehicle, Timer {

    @Override
    public void start() {
        Timer.super.start();
        // Timer.super.start(); // Rule 3 - in case of ambiguity, tell explicitely
    }

    @Override
    public void stop() {
        System.out.println("IndianVehicle::stop");
    }
}

interface Timer {

    default void start() {
        System.out.println("Timer::start");
    }

    default void stop() {
        System.out.println("Timer::stop");
    }

}

public class DefaultInterfaceMethodMain {

    public static void main(final String[] args) {
        final Vehicle b = new IndianCarVehicle();
        b.start();
        // Vehicle v1 = new IndianCarVehicle();
        // v1.start();
        // v1.stop();
    }
}