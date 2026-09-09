package triangle2;

public class Triangle {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double findArea() {
        return (base * height) / 2.0;
    }

    public boolean isSameArea(Triangle t) {
        return this.findArea() == t.findArea();
    }
}