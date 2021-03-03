package item21_22_23;

//Class hierarchy replacement for a tagged class
public abstract class Figure1 {
	abstract double area();
}

class Circle1 extends Figure1 {
	final double radius;

	public Circle1(double radius) {
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * radius * radius;
	}

}

class Rectangle extends Figure1 {
	final double length;
	final double width;

	public Rectangle(double width, double length) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}
}

class Square extends Rectangle {

	public Square(double side) {
		super(side, side);
	}

}
