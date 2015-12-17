package designPatterns.staticFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author rohankar
 */
public class VehicleFactory {

    private final Map<String, Supplier<Vehicle>> registry = new HashMap<>();

    public void register(final String name, final Supplier<Vehicle> factory) {
        registry.put(name, factory);
    }

    public Vehicle create(final String name) {
        return registry.getOrDefault(name, () -> {
            throw new IllegalArgumentException();
        }).get();
    }
}
