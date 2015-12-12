package functionaInterface;

public class ConverterMain {

    public static void main(final String[] args) {

        // Converter<String, Integer> converter = (s) -> Integer.valueOf(s);
        final Converter<String, Integer> converter = Integer::valueOf; // method reference
        System.out.println(converter.convert("10"));
    }

}