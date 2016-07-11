package designPatterns.chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author rohankar
 */
public class App {

    public static Optional<Boolean> managerApprove(final Purchase purchase) {
        return purchase.amount() < 20 ? Optional.of(true) : Optional.empty();
    }

    public static Optional<Boolean> vpApprove(final Purchase purchase) {
        return purchase.amount() < 50 ? Optional.of(true) : Optional.empty();
    }

    public static Optional<Boolean> ceoApprove(final Purchase purchase) {
        return purchase.amount() < 100 ? Optional.of(true) : Optional.empty();
    }

    public static void main(final String[] args) {
        final Purchase purchase = new Purchase(40);

        final Boolean approved =
            Stream.<Function<Purchase, Optional<Boolean>>>of(App::managerApprove, App::vpApprove, App::ceoApprove)
                .map(f -> f.apply(purchase)) //
                .filter(Optional::isPresent) //
                .findFirst() //
                .flatMap(Function.identity()) //
                .orElseThrow(() -> new RuntimeException("Can not be approved!"));
        System.err.println(approved);
    }
}
