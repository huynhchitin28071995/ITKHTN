package item21_22_23;

//Constant interface anti-pattern - do not use
public interface ConstantInterface {
	// Avaogadro's number (1/mol)
	static final double AVOGADROS_NUMBER = 6.022_140_857e23;

	// Boltzmann constant (J/K)
	static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

	// Mass of the electron (kg)
	static final double ELECTRON_MASS = 0.109_383_56e-31;

	public static void main(String[] args) {
		System.out.println(PhysicalConstants.AVOGADROS_NUMBER);
	}
}

//Ultility class version of the class above, use this
class PhysicalConstants {

	// Prevents instantiation
	private PhysicalConstants() {
	}

	public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
	public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
	public static final double ELECTRON_MASS = 0.109_383_56e-31;
}