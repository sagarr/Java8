package designPatterns.template;

/**
 * @author rohankar
 */
public abstract class FilterLogger implements Logger, Filter {

    private final Logger logger;

    public FilterLogger(final Logger logger) {
        this.logger = logger;
    }

    /* template method */
    @Override
    public abstract boolean accept(final String msg);

    @Override
    public void log(final String msg) {
        if (accept(msg)) {
            logger.log(msg);
        }
    }

    // Inheritance is bad, favor composition over inheritance
}
