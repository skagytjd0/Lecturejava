package triangle;

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


public class TriangleTest {
    public static void main(String[] args) {
        Triangle t1 = new Triangle(10.0, 5.0); // 넓이: 25.0
        Triangle t2 = new Triangle(5.0, 10.0); // 넓이: 25.0
        Triangle t3 = new Triangle(8.0, 8.0);  // 넓이: 32.0

        System.out.println(t1.isSameArea(t2)); // true (25.0 == 25.0)
        System.out.println(t1.isSameArea(t3)); // false (25.0 == 32.0)
    }
}