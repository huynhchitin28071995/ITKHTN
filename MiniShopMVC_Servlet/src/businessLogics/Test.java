package businessLogics;

public class Test {
	static class MyClass {
		public int x;

		public MyClass(int x) {
			this.x = x;
		}
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
//		Publisher p = new Publisher.Builder().build();
//		System.out.println(p.toString()); // can see that there is no way to alter p's fields
//		Publisher p1 = new Publisher.Builder().publisherName("This is the new publisher").build();
//		System.out.println(p1.toString());
//		System.out.println(p.equals(p1));
//		Publisher p2 = new Publisher.Builder().build();
//		System.out.println(p.equals(p));// cannot alter p's fields so this will always true
//		System.out.println(p.equals(p2));
//		try {
//			System.out.println(p.equals(p.clone()));
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}

		// Test add publisher
//		PublisherBL.addPublisher(p1);
		// test PublisherBL
//		System.out.println(PublisherBL.getPublisher(19).toString()); //Must print 'Test'
//		PublisherBL.editPublisher(19,"This is the new publisher");
//		PublisherBL.getPublishers().forEach(publisher -> System.out.println(publisher.toString())); //19: This is the new publisher
//		System.out.println(PublisherBL.getPublisher(19).toString()); //Must print 'This is the new publisher'
//		
//		PublisherBL.editPublisher(19, "New publisher name");
//		System.out.println(PublisherBL.getPublisher(19).toString()); //Must print 'New publisher name'
//		
//		PublisherBL.deletePublisher(19);
//		System.out.println(PublisherBL.getPublisher(19).toString()); //Must be 'null'

		// Test ProductBL
//		Test dsProduct if it's a list
//		ProductBL.getProducts(0, 5).forEach(p -> System.out.println(p.toString()));

		// Test MemberBL
//		Member m = new Member.Builder().username("test").password("1").build();
//		MemberBL.addMember(m);
//		MemberBL.getMemberList().forEach(Member::println);
//		MemberBL.logOn("tin1", "1234").println();

		MyClass a = new MyClass(1);
		MyClass b = new MyClass(2);
		System.out.println(a.x + " " + b.x);
		swap(a.x, b.x);
		System.out.println(a.x + " " + b.x);
		Test t = new Test();
		t.swap(10, 20);
	}
}
