package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 例如有 3 种果子，数目依次为 1 ， 2 ， 9 。可以先将1 、 2堆合并，新堆数目为 3 ，耗费体力为 3 。
 * 接着，将新堆与原先的第三堆合并，又得到新的堆，数目为 1212 ，耗费体力为 12 。所以多多总共耗费体力 =3+12=15=3+12=15 。
 * 可以证明 15 为最小的体力耗费值。
 * 
 * 怎么感觉像树   -----哈弗曼树
 */
public class 贪心P1090 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, sum = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] a = new int[n];// 实际存放每一堆
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		// 每次排序，最小 太慢
		int i = 0;
		while (i <a.length-1) {
			Arrays.sort(a, i, a.length - 1);
			sum = sum+ a[i] + a[i + 1];
			a[i + 1] = sum;
			i++;
		}
		System.out.println(sum);
		
	}

}
