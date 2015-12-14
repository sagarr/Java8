package designPatterns.template;

/**
 * @author rohankar
 */
public class BetterFilterLogger implements Logger {

    private final Filter filter;
    private final Logger logger;

    public BetterFilterLogger(final Filter filter, final Logger logger) {
        this.filter = filter;
        this.logger = logger;
    }

    @Override
    public void log(final String msg) {
        if (filter.accept(msg)) {
            logger.log(msg);
        }
    }

}
