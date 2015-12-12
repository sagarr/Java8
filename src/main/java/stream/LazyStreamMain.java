package stream;

import java.util.*;

public class LazyStreamMain {

    public static void main(final String[] args) {
        final List<Integer> nos = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(nos.stream().filter(LazyStreamMain::isGreaterThan10).filter(LazyStreamMain::isEven)
            .map(n -> n * 2).findFirst().orElse(0)
        /* .get() */);
    }

    public static boolean isGreaterThan10(final int number) {
        System.out.println("isGreater " + number);
        return number > 10;
    }

    public static boolean isEven(final int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(final int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }
}