package item21_22_23;

//can not use static import to avoid qualifying constants
public class Test {
	PhysicalConstants pc;

	double atoms(double mols) {
		return PhysicalConstants.AVOGADROS_NUMBER * mols;

	}

	public static void main(String[] args) {
		Figure f = new Figure(1);
		Figure f1 = new Figure(2, 3);
		System.out.println(f.area());
		System.out.println(f1.area());

		Figure1 f2 = new Circle1(10);
		Figure1 f3 = new Rectangle(5, 5);
		System.out.println(f2.area());
		System.out.println(f3.area());

	}
}
