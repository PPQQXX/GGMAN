package Algorithm;

import java.util.Scanner;
/*
 * static���Ի�ȥ��һ����
 */
public class DFS_1_1 {
	public static int count;// ��̬ Ĭ��0
	public static int[] a = new int[10];
	public static int[] book = new int[10]; // �洢״̬������
	public static int n;
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		// i��ʾ��i�������ŵ���i��������±���㿪ʼ ��i==n+1�����һ���ĺ���
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
				book[j] = 0;// ����ʱ����Ϊ0
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