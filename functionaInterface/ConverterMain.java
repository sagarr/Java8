
public class ConverterMain {
	
	public static void main(String[] args) {
	
		// Converter<String, Integer> converter = (s) -> Integer.valueOf(s);
		Converter<String, Integer> converter = Integer::valueOf; // method reference
		System.out.println(converter.convert("10"));
	}

}