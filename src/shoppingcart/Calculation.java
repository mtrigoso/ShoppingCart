package shoppingcart;

public class Calculation {
	public static int findMax(int arr[]) {
		int max = arr[0];
		if (arr.length == 0 || arr == null) {
			throw new IllegalArgumentException("no max to be found");
		} else {
			for (int i = 0; i < arr.length; i++) {
				if(max < arr[i]) max = arr[i];
			} 
		} return max;
	}
}