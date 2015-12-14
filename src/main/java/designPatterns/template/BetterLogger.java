package designPatterns.template;

/**
 * @author rohankar
 */
@FunctionalInterface
public interface BetterLogger {

    void log(String msg);

    /*
     * higher order functions using lambda - use of 'static' method like companion object.
     */
    public static BetterLogger filterLogger(final BetterLogger logger, final Filter filter) {
        return msg -> {
            if (filter.accept(msg)) {
                logger.log(msg);
            }
        };
    }

    /*
     * Function composition using lambda - use of 'default' instance method.
     */
    public default BetterLogger filterLogger2(final Filter filter) {
        return msg -> {
            if (filter.accept(msg)) {
                log(msg);
            }
        };
    }
}