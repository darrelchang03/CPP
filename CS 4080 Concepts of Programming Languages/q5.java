import java.util.function.Function;

public class q5 {

    public static String shout(String text) {
        return text.toUpperCase();
    }

    public static String whisper(String text) {
        return text.toLowerCase();
    }

    public static void greet(Function<String, String> func) {
        String greeting = func.apply("Hi, How're you?");
        System.out.println(greeting);
    }

    public static void main(String[] args) {
        System.out.println();
        greet(q5::shout);
        greet(q5::whisper);
    }
}
