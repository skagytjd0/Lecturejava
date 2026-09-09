package circle;

public class Circle {
	final double PI = 3.14159;
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;

	}
	public double getArea() {
		return radius * radius * PI;

	
	}
	
	public double getRadius() {
		return radius;
	}
}



