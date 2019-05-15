package sort;

import java.util.Comparator;

public class QuickSort implements Sort {

	@Override
	public <T> void sort(T[] a) {
		// TODO Auto-generated method stub
		int l = 0, r = a.length - 1;
		quickSort(a, l, r);
	}

	public <T> void quickSort(T[] a, int l, int r) {
		int i, j;
		T t, temp;
		
		if (l > r) {
			return;
		}
		temp = a[l];
		i = l;// 左
		j = r;// 右
		while (i != j) {
			//怎么比较，
			//comparable,comparator
			while ( i < j)
				if () {
					
					j--;
				}
				
			while (i < j)
				if () {
					i++;
				}
				
			if (i < j) {
				t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}
		// 将基数归位
		a[l] = a[i];
		a[i] = temp;

		quickSort(a, l, i - 1);// zuo digui
		quickSort(a, i + 1, r);// you digui
	}

	public <T> boolean compare(T a,T temp) {
		
		return false;
	}

	/*
	 * @Override 
	 * public void sort(int[] a) { // TODO Auto-generated method stub int
	 * l=0,r=a.length-1; quickSort(a, l, r); }
	
	 * public void quickSort(int[] a, int l, int r) { int i, j, t, temp; if (l > r)
	 * { return; }
	 * 
	 * temp = a[l]; i = l;// 左 j = r;// 右 while (i != j) { while (a[j] >= temp && i
	 * < j) j--; while (a[i] <= temp && i < j) i++; if (i < j) { t = a[j]; a[j] =
	 * a[i]; a[i] = t; } } // 将基数归位 a[l] = a[i]; a[i] = temp;
	 * 
	 * quickSort(a, l, i - 1);// zuo digui quickSort(a, i + 1, r);// you digui }
	 */

}
