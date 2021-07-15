package fundamentals.maintask.tasktwo;

public class Line {
    private String line;
    private String reverse;

    public Line(String line) {
        this.line = line;
    }

    public String mReverse() {
        String reverse = new StringBuffer(line).reverse().toString();
        return reverse;
    }
}
