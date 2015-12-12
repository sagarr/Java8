package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaMain {

    public static void main(final String[] args) {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // for (int i = 0; i < list.length(); i++) {
        // System.out.println(list.get(i));

        // }

        // for (Integer i : list) {
        // System.out.println(i);
        // }

        // list.forEach(new Consumer<Integer>() {
        // public void accept(Integer value) {
        // System.out.println(value);
        // }
        // });

        // list.forEach((Integer value) -> {
        // System.out.println(value);
        // });

        // list.forEach((value) -> System.out.println(value));

        list.forEach(System.out::println);

        //
        /// another example
        //
        // List<String> names = Arrays.asList("Sagar", "Rohit", "Amit");

        // Collections.sort(names, new Comparator<String>() {

        // public int compare(String a, String b) {
        // return a.compareTo(b);
        // }
        // });

        // Collections.sort(names, (String a, String b) -> {
        // return a.compareTo(b);
        // });

        // Collections.sort(names, (a, b) -> a.compareTo(b));

        // System.out.println(names);
    }
}