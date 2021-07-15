package additional.one;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingPoem {
    private static final String POEM =
            "From fairest creatures we desire increase,\n" +
                    "A summer day,\n" +
                    "Has rain or sun,\n" +
                    "But either way\n" +
                    "I find it fun.\n" +
                    "To stand in rain\n" +
                    "That/s pouring down\n" +
                    "Or lie in sun\n" +
                    "That paints me brown.\n";

    private static final Comparator<String> LINE_LENGTH_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };

    public static void main(String[] args) {
        List<String> lines = Arrays.asList(POEM.split("\n"));
        System.out.println(lines);

        Collections.sort(lines, LINE_LENGTH_COMPARATOR);
        System.out.println(lines);
    }
}
