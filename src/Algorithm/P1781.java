package Algorithm;
 
import java.util.Arrays;
import java.util.Comparator;
 
public class P1781 {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
		Integer[] array = { Integer.valueOf(6), Integer.valueOf(8),
				Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(9),
				Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(90),
				Integer.valueOf(310), Integer.valueOf(67),
				Integer.valueOf(300), Integer.valueOf(78) };
		System.out.println(Arrays.toString(array));
		quickSort(array, 0, array.length - 1, new Comparator<Integer>() {
 
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
			}
		});
		System.out.println(Arrays.toString(array));
	}
 
	public static <T> void quickSort(T[] array, int lowIndex, int highIndex,
			Comparator<T> comparator) {
		if (lowIndex >= highIndex) {
			return;
		}
 
		int i = lowIndex;
		int j = highIndex;
 
		T key = array[lowIndex];
 
		while (true) {
			while (i < j) {
				if (comparator.compare(array[j], key) < 0) {
					array[i] = array[j];
					break;
				}
				j--;
			}
 
			while (i < j) {
				if (comparator.compare(array[i], key) > 0) {
					array[j] = array[i];
					break;
				}
				i++;
			}
 
			if (i == j) {
				array[j] = key;
 
				quickSort(array, lowIndex, j - 1, comparator);
				quickSort(array, j + 1, highIndex, comparator);
 
				return;
			}
 
			System.out.println(Arrays.toString(array));
		}
	}
}