package designPatterns.chainofresponsibility;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author rohankar
 */
public class App {

    public static void main(final String[] args) {
        final Purchase purchase = new Purchase(40);

        final Boolean approved = Stream
            .<Function<Purchase, Optional<Boolean>>>of( //
                Approvers::managerApprove, //
                Approvers::vpApprove, //
                Approvers::ceoApprove)
            .map(f -> f.apply(purchase)) //
            .filter(Optional::isPresent) //
            .findFirst() //
            .flatMap(Function.identity()) //
            .orElseThrow(() -> new RuntimeException("Can not be approved!"));
        System.err.println(approved);
    }
}
