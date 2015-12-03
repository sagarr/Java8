import java.lang.annotation.Repeatable;

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Hint("hint 1")
@Hint("hint 1")
class Person {

}

public class AnnotationMain {
	
	public static void main(String[] args) {
		System.out.println(Person.class.getAnnotationsByType(Hint.class));		
	}
}