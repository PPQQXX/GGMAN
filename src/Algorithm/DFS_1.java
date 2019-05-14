package Algorithm;

import java.util.Scanner;

/*
 *
 * ����  ---ֽ��
 */
public class DFS_1 {
	public static void main(String[] args) {
		int n;// n����
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		int[] a = new int[n + 1];
		int[] book = new int[n + 1];// ��ʼ��������� 0δʹ�� �±��0��ʼ
		for (int i = 0; i < n + 1; i++) {
			book[i] = 0;
			a[i] = 0;
		}
		dfs(1, a, book, n);
	}

	private static void dfs(int i, int[] a, int[] book, int n) {
		// TODO Auto-generated method stub
		// i��ʾ��i�������ŵ���i��������±���㿪ʼ ��i==n+1�����һ���ĺ���
		if (i == n+1) {
			for (int j = 1; j < a.length; j++) {
				System.out.print(a[j] + "~~");//����ĵ�һ����a[i]��0��
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
				book[j] = 0;// ����ʱ����Ϊ0
			}
		}
		return;
	}
}
