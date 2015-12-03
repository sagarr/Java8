import java.util.*;

public class OptionalMain {

	public static void main(String[] args) {
		Optional<String> foo = Optional.ofNullable(null);

		System.out.println(foo.isPresent());
		System.out.println(foo.get());
		System.out.println(foo.orElse("no foo"));
	}
}