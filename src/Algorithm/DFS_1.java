package Algorithm;

import java.util.Scanner;

/*
 *
 * 箱子  ---纸牌
 */
public class DFS_1 {
	public static void main(String[] args) {
		int n;// n个数
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		reader.close();
		int[] a = new int[n + 1];
		int[] book = new int[n + 1];// 初始化标记数组 0未使用 下标从0开始
		for (int i = 0; i < n + 1; i++) {
			book[i] = 0;
			a[i] = 0;
		}
		dfs(1, a, book, n);
	}

	private static void dfs(int i, int[] a, int[] book, int n) {
		// TODO Auto-generated method stub
		// i表示第i个数，放到第i个盒子里，下标从零开始 当i==n+1，最后一个的后面
		if (i == n+1) {
			for (int j = 1; j < a.length; j++) {
				System.out.print(a[j] + "~~");//输出的第一行中a[i]是0？
				if (j %(n)== 0) {
					System.out.println();
				}
			}
		}

		for (int j = 1; j <=n; j++) {//
			if (book[j] == 0) {
				a[i] = j;
				book[j] = 1;
				dfs(i + 1, a, book, n);
				book[j] = 0;// 返回时，置为0
			}
		}
		return;
	}
}
