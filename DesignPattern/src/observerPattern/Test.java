package observerPattern;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		WeatherData wd = new WeatherData();
		CurrentConditionDisplay ccd = new CurrentConditionDisplay(wd);
		HeatIndexDisplay hid = new HeatIndexDisplay(wd);
		while (true) {
			System.out.println("Please insert Humidity: ");
			wd.setHumidity(sc.nextFloat());
			System.out.println("Please insert Temperature: ");
			wd.setTemperature(sc.nextFloat());
		}
//		sc.close();

	}
}
