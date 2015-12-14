package designPatterns.decorator;

/**
 * @author rohankar
 */
@FunctionalInterface
public interface BetterLogger2 {

    public enum Level {
        INFO, ERROR
    }

    void log(Level level, String msg);

    default BetterLogger level(final Level level) {
        return message -> log(level, message);
    }

}
