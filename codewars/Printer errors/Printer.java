import java.util.stream.IntStream;

public class Printer {

    public static String printerError(String s) {
        char[] c = s.toCharArray();
        return IntStream.range(0,c.length)
                .filter(i -> c[i] < 'a' || c[i] > 'm')
                .count() + "/" + c.length;
    }
}