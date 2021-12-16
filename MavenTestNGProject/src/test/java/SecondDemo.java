import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondDemo {

	@Test
	public static void test4() {
		System.out.println("Hello World4");
		Assert.assertEquals(false, true);
	}
	@Test
	public static void test5() {
		System.out.println("Hello World5");
		Assert.assertEquals(false, true);
	}
	@Test
	public static void test6() {
		System.out.println("Hello World6");
	}
}
