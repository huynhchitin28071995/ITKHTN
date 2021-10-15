package decoratorPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		Beverage bev = new Espresso();
		System.out.println(bev.getDescription());

		Beverage bev2 = new DarkRoast();
		System.out.println(bev2.getDescription());
		System.out.println(bev2.cost());

		bev2 = new Mocha(bev2);
		System.out.println(bev2.getDescription());
		System.out.println(bev2.cost());

		bev2 = new Mocha(bev2);
		System.out.println(bev2.getDescription());
		System.out.println(bev2.cost());

		int c;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
