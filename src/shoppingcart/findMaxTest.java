package shoppingcart;

import org.junit.Test;
import static org.junit.Assert.*;

public class findMaxTest {
	//create new calculation obj
	Calculation calc = new Calculation();
	//arr's for passTests
	int arr1[] = {1, 2, 3, 4, 5, 6};
	int arr2[] = {-6, -5, -4, -3, -2, -1};
	//arr's for failTests
	int arr3[] = {-1, -2, -3, -4, -5};
	int arr4[] = {4, 3, 6, 2, 1, 5};

	@Test
	public void passTest() {
		int max1 = calc.findMax(arr1);
		int max2 = calc.findMax(arr2);
		//compare actual max value in arr's to method calculated max values
		assertEquals(6, max1);
		assertEquals(-1, max2);
	}
	
	@Test
	public void failTest() {
		int max3 = calc.findMax(arr3);
		int max4 = calc.findMax(arr4);
		//provides failed tests
		assertEquals(-5, max3);
		assertEquals(5, max4);
		//provides a false positive
		assertFalse(-1 == max3);
		assertFalse(4 == max4);
	}
}