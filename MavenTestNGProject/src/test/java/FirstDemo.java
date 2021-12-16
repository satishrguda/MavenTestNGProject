import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDemo {

	@Test
	public static void test1() {
		String firstName = "John ";
		String lastName = "Doe";
		System.out.println(firstName.concat(lastName));
		System.out.println(firstName.substring(1,3));
		System.out.println(firstName.contains(lastName));
	}
	
	@Test
	public static void test2() {
		System.out.println("Hello World2");
	}
	@Test
	public static void test3() {
		System.out.println("Hello World3");
		Assert.assertEquals(false, true);
	}
}
