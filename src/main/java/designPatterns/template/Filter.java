package designPatterns.template;

/**
 * @author rohankar
 */
@FunctionalInterface
public interface Filter {

    boolean accept(String msg);
}
