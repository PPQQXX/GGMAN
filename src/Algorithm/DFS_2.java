package Algorithm;

import java.util.Scanner;
/*
 * 5 4 0 0 1 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 1 1 1 4 3
  输入数据
  图大小限制51下
 */
public class DFS_2 {
	public static int sx, sy, px, py, min = 9999;// 起始点坐标，目标点坐标
	public static int n, m;// n行m列
	//在这里可以直接把n，m给数组，但，还没输入，默认值为0,,,实际上无效
	public static int[][] book = new int[51][51];// 标记
	public static int[][] a = new int[51][51];// 二维数组表示图
	// int[][]不可以直接指定 申明时不可以分配空间
	public static int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 右边开始 顺时针旋转4

	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		// 读入n行，m列
		n = rd.nextInt();
		m = rd.nextInt();
		// 读入图
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = rd.nextInt();
			}
		}
		// 起点终点
		sx = rd.nextInt();
		sy = rd.nextInt();
		px = rd.nextInt();
		py = rd.nextInt();
		rd.close();
		book[sx][sy] = 1;// 起始点 置为1
		dfs(sx, sy, 0);
		System.out.println(min);
	}

	public static void dfs(int x, int y, int step) {// 坐标x.y。步数step
		int tx = x, ty = y;
		// 判断是否到达指定位置
		if (tx == px && ty == py) {
			if (step < min)
				min = step;
			return;
		}
		// 计算下一步的坐标
		for (int i = 0; i <= 3; i++) {
			tx = x + next[i][0];
			ty = y + next[i][1];
			// 判断是否越界
			if (tx < 1 || tx > n || ty < 1 || ty > m)
				continue;
			if (a[tx][ty] == 0 && book[tx][ty] == 0)// 1表示走不通,0表示通
			{
				book[tx][ty] = 1;
				dfs(tx, ty, step + 1);
				book[tx][ty] = 0;
			}
		}
		return;
	}
}
