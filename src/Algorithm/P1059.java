package Algorithm;


/**
 * 3500K,1000ms
 * 快速排序+手动去重
 * 下一个尝试set加去重
 */
import java.util.Scanner;

public class P1059 {
	public static void main(String[] args) {
		int n;
		int i;
		/*
		 * BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		 * n=Integer.parseInt(bf.readLine());
		 */
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		int[] array = new int[n];
		for (i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		// 先排序
		quickSort(array, 0, n - 1);
		// 再去重
		int tem = remove(array, n - 1);

		System.out.println(tem);
		for (i = 0; i < tem; i++) {
			System.out.print(array[i] + " ");
		}
		//System.out.println(array[i]);
		System.out.println();

	}

	private static int remove(int[] a, int n) {
		int bn=n+1;
		int b[] = new int[bn];
		int num = 0;// b的下表
		b[num++] = a[0];
		for (int i = 1; i <=n; i++) {
			if (a[i - 1] != a[i]) {
				b[num++] = a[i];
			}
		}
		for (int i = 0; i <num; i++) {
			a[i]=b[i];
		}
		return num;
	}

	private static void quickSort(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		int i, j, t, temp;
		if (l > r) {
			return;
		}
		temp = a[l];
		i = l;// 左
		j = r;// 右
		while (i != j) {
			while (a[j] >= temp && i < j)
				j--;
			while (a[i] <= temp && i < j)
				i++;
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
}
