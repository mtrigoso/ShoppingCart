package shoppingcart;

import org.junit.Test;
import org.junit.*;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import junit.framework.TestCase;
import static org.junit.Assert.*;


public class ShoppingCartTest {
	ShoppingCart emptyCart = new ShoppingCart();
	ShoppingCart addCart = new ShoppingCart();
	ShoppingCart rmCart = new ShoppingCart();
	
	//Products to add to ShoppingCart objs.
	Product apple = new Product("apple", 1.25);
	Product cheese = new Product("cheese", 2.50);
	Product milk = new Product("milk", 3.50);
	Product bread = new Product("bread", 1.50);
	
	//countIncrement as countI
	int countI = 0;
	//countDecrement as countD
	int countD = 0;

	@Test
    public void testNewCart() {
		//create new shopping cart obj and test its item count is 0.
		ShoppingCart newCart = new ShoppingCart();
        assertEquals(newCart.getItemCount(), 0);
	}
	
	@Test
	public void testEmptyCart() {
		//check cart is empty, add products to cart, check cart !empty, empty cart, check cart is empty.
		assertEquals(emptyCart.getItemCount(), 0);
		emptyCart.addItem(bread);
		emptyCart.addItem(cheese);
		assertFalse(emptyCart.getItemCount() == 0);
		emptyCart.empty();
		assertTrue(emptyCart.getItemCount() == 0);
	}
	
	@Test
	public void testAddItem() {
		//tests manual countI against cart itemCount to ensure itemCount is incrementing properly.
		assertEquals(addCart.getItemCount(), countI);
		addCart.addItem(apple);
		countI++;
		addCart.addItem(apple);
		//tests countI is working properly.
		assertFalse(addCart.getItemCount() == countI);
		countI++;
		addCart.addItem(milk);
		countI++;
		addCart.addItem(bread);
		countI++;
		assertEquals(addCart.getItemCount(), countI);
		addCart.addItem(cheese);
		countI++;
		assertEquals(addCart.getItemCount(), countI);
		assertEquals(countI, 5);
	}
	
	@Test
	public void testRmItem() {
		//tests manual countD against cart itemCount to ensure itemCount is decrementing properly.
		assertEquals(rmCart.getItemCount(), countD);
		//we want strong bones.
		rmCart.addItem(milk);
		countD++;
		rmCart.addItem(milk);
		countD++;
		rmCart.addItem(milk);
		countD++;
		rmCart.addItem(milk);
		assertFalse(rmCart.getItemCount() == countD);
		countD++;
		assertEquals(rmCart.getItemCount(), countD);
		try {
			//we do not want strong bones anymore.
			rmCart.removeItem(milk);
			countD--;
			rmCart.removeItem(milk);
			countD--;
			rmCart.removeItem(milk);
			countD--;
		} catch(ProductNotFoundException nomilk) {
			System.out.println("no milk");
		} 
		
		assertEquals(rmCart.getItemCount(), countD);
		assertEquals(countD, 1);
	}
}
