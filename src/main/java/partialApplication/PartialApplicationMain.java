package partialApplication;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author rohankar
 */
public class PartialApplicationMain {

    public static void main(final String[] args) {
        final Path path = FileSystems.getDefault().getPath("./src/main/java/partialApplication", "double.csv");
        System.out.println(SumCSV.parseAndSum(path));
        System.out.println(SumCSV.parseAndSum2(path));

        // partial application - separating parsing and sum
        class Adder {
            int sum;
        }
        final Adder adder = new Adder();
        CSVParser.parse(path, (value) -> adder.sum += value);
        System.out.println(adder.sum);
    }

}
