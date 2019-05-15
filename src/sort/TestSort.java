package sort;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 9, 8, 7, 6, 1, 5, 4, 3, 2 };
		QuickSort qs = new QuickSort();
		qs.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
