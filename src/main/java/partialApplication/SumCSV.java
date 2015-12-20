package partialApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author rohankar
 */
public class SumCSV {

    public static double parseAndSum(final Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.flatMap(line -> Arrays.stream(line.split(","))) //
                .mapToDouble(t -> Double.parseDouble(t)) //
                .sum();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * using method reference.
     */
    public static double parseAndSum2(final Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.flatMap(Pattern.compile(",")::splitAsStream) //
                .mapToDouble(Double::parseDouble) //
                .sum();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
