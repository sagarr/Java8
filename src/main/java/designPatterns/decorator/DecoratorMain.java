package designPatterns.decorator;

import designPatterns.decorator.Logger.Level;

/**
 * @author rohankar
 */
public class DecoratorMain {

    public static void main(final String[] args) {
        final Logger logger = (level, msg) -> System.out.println(level + ": " + msg);
        logger.log(Level.INFO, "knock knock");

        final BetterLogger2 logger2 = (level, msg) -> System.out.println(level + ": " + msg);
        final BetterLogger betterLogger = logger2.level(BetterLogger2.Level.INFO);
        betterLogger.log("Hello there!");
    }
}
