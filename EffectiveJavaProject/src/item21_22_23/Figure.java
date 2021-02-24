package item21_22_23;

//Tagged class - vastly inferior to a class hierarchy
public class Figure {
	enum Shape {
		RECTANGLE, CIRCLE
	};

	// Tag field - the shape of this figure, must have constructor or initialize
	// with null
	final Shape shape;

	// These field are used only if shape is RECTANGLE
	double length;
	double width;

	// This field is used only if shape is CIRCLE
	double radius;

	// Constructor for circle
	Figure(double radius) {
		shape = Shape.CIRCLE;
		this.radius = radius;
	}

	// Constructor for rectangle, must initialize shape
	Figure(double length, double width) {
		this.shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError(shape);
		}
	}
}
//Error prone, inefficient
