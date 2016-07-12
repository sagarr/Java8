package designPatterns.chainofresponsibility;

import java.util.Optional;

/**
 * @author rohankar
 */
public class Approvers {

    public static Optional<Boolean> managerApprove(final Purchase purchase) {
        return purchase.amount() < 20 ? Optional.of(true) : Optional.empty();
    }

    public static Optional<Boolean> vpApprove(final Purchase purchase) {
        return purchase.amount() < 50 ? Optional.of(true) : Optional.empty();
    }

    public static Optional<Boolean> ceoApprove(final Purchase purchase) {
        return purchase.amount() < 100 ? Optional.of(true) : Optional.empty();
    }

}
