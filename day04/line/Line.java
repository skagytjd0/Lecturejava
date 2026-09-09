package line;

public class Line {
    private double length;

    public Line(double length) {
        this.length = length;
    }

    public boolean isSameLine(Line target) {
        return this.length == target.length;
    }
}