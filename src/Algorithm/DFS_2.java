package Algorithm;

import java.util.Scanner;
/*
 * 5 4 0 0 1 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 1 1 1 4 3
  ��������
  ͼ��С����51��
 */
public class DFS_2 {
	public static int sx, sy, px, py, min = 9999;// ��ʼ�����꣬Ŀ�������
	public static int n, m;// n��m��
	//���������ֱ�Ӱ�n��m�����飬������û���룬Ĭ��ֵΪ0,,,ʵ������Ч
	public static int[][] book = new int[51][51];// ���
	public static int[][] a = new int[51][51];// ��ά�����ʾͼ
	// int[][]������ֱ��ָ�� ����ʱ�����Է���ռ�
	public static int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// �ұ߿�ʼ ˳ʱ����ת4

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		// ����n�У�m��
		n = rd.nextInt();
		m = rd.nextInt();
		// ����ͼ
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = rd.nextInt();
			}
		}
		// ����յ�
		sx = rd.nextInt();
		sy = rd.nextInt();
		px = rd.nextInt();
		py = rd.nextInt();
		book[sx][sy] = 1;// ��ʼ�� ��Ϊ1
		dfs(sx, sy, 0);
		System.out.println(min);
	}

	public static void dfs(int x, int y, int step) {// ����x.y������step
		int tx = x, ty = y;
		// �ж��Ƿ񵽴�ָ��λ��
		if (tx == px && ty == py) {
			if (step < min)
				min = step;
			return;
		}
		// ������һ��������
		for (int i = 0; i <= 3; i++) {
			tx = x + next[i][0];
			ty = y + next[i][1];
			// �ж��Ƿ�Խ��
			if (tx < 1 || tx > n || ty < 1 || ty > m)
				continue;
			if (a[tx][ty] == 0 && book[tx][ty] == 0)// 1��ʾ�߲�ͨ,0��ʾͨ
			{
				book[tx][ty] = 1;
				dfs(tx, ty, step + 1);
				book[tx][ty] = 0;
			}
		}
		return;
	}
}
