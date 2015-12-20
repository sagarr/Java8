package partialApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author rohankar
 */
public class CSVParser {

    public static void parse(final Path path, final Observer observer) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.flatMap(Pattern.compile(",")::splitAsStream)//
                .mapToDouble(Double::parseDouble) //
                .forEach(observer::data); // partial application using instance method reference
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
