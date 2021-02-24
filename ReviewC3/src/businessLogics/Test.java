package businessLogics;

import models.Publisher;

public class Test {
	public static void main(String[] args) {
		Publisher p = new Publisher.Builder().build();
		System.out.println(p.toString()); // can see that there is no way to alter p's fields
		Publisher p1 = new Publisher.Builder().publisherId(14).publisherName("Test").build();
		System.out.println(p1.toString());
		System.out.println(p.equals(p1));
		Publisher p2 = new Publisher.Builder().build();
		System.out.println(p.equals(p));// cannot alter p's fields so this will always true
		System.out.println(p.equals(p2));
		try {
			System.out.println(p.equals(p.clone()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// test PublisherBL
		PublisherBL.getPublishers().forEach(publisher -> System.out.println(publisher.getPublisherName()));
	}
}
