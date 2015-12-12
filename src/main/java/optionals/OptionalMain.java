package optionals;

import java.util.Optional;

public class OptionalMain {

    public static void main(final String[] args) {
        final Optional<String> foo = Optional.ofNullable(null);

        System.out.println(foo.isPresent());
        System.out.println(foo.get());
        System.out.println(foo.orElse("no foo"));
    }
}