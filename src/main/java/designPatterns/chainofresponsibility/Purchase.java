package designPatterns.chainofresponsibility;

/**
 * @author rohankar
 */
public class Purchase {

    private final int amount;

    public Purchase(final int amount) {
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

}
