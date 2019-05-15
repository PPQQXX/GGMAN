package Algorithm;

import java.util.Scanner;
/*
 * static可以回去看一下了
 */
public class DFS_1_1 {
	public static int count;// 静态 默认0
	public static int[] a = new int[10];
	public static int[] book = new int[10]; // 存储状态的数组
	public static int n;
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		// i表示第i个数，放到第i个盒子里，下标从零开始 当i==n+1，最后一个的后面
		if (i == n + 1) {
			count++;
			for (int j =1; j <=n; j++) {
				System.out.print(a[j] + "~~");
				if (j %(n)== 0) {
					System.out.println();
				}
			}
		}

		for (int j = 1; j <= n; j++) {//
			if (book[j] == 0) {
				a[i] = j;
				book[j] = 1;
				dfs(i + 1);
				book[j] = 0;// 返回时，置为0
			}
		}
		return;
	}

	public static void main(String[] ages) {
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		for (int i = 0; i < n + 1; i++) {
			book[i] = 0;
			a[i] = 0;
		}
		dfs(1);
		System.out.println(count);
	}
}