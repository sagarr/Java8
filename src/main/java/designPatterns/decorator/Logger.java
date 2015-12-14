package designPatterns.decorator;

/**
 * @author rohankar
 */
public interface Logger {

    public enum Level {
        INFO, ERROR
    }

    void log(Level level, String msg);

}
