package stream;

import java.util.*;

public class StreamMain {

    public static void main(final String[] args) {
        // example 1
        final Collection<String> strings = Arrays.asList("dda", "sda", "adw", "sfa");
        strings.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);

        // example 2
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sumEvenNos(numbers));
        System.out.println(sumOddNos(numbers));
        System.out.println(numbers.stream().filter(n -> n % 2 == 0).reduce(Integer::sum));
    }

    private static int sumEvenNos(final List<Integer> numbers) {
        int sum = 0;
        for (final Integer n : numbers) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

    private static int sumOddNos(final List<Integer> numbers) {
        int sum = 0;
        for (final Integer n : numbers) {
            if (n % 2 != 0) {
                sum += n;
            }
        }
        return sum;
    }
}