package Algorithm;

import java.util.Scanner;


/*
 *比较DFS_2
 5 4 0 0 1 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 1 1 1 4 3
  输入数据
 *一个队列que[2501]
 *a[][]存图
 *book[][]标记
 */
public class BFS_1 {
	public static int sx, sy, px, py;// 起始点坐标，目标点坐标
	public static int n, m;// n行m列
	// 在这里可以直接把n，m给数组，但，还没输入，默认值为0,,,实际上无效
	public static Que[] que = new Que[500]; // 队列  2501
	public static int head, tail; // 头，最后的后面
	public static int[][] book = new int[51][51];// 标记
	public static int[][] a = new int[51][51];// 二维数组表示图
	public static int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 右边开始 顺时针旋转4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag = 0;
		int tx = 0, ty = 0;
		Scanner rd = new Scanner(System.in);
		//这个地方注意
		for (int i = 0; i < 500; i++) {
			que[i]=new Que();
		}
		
		
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

		// 队列初始化
		head = 1;
		tail = 1;
		que[tail].x = sx;
		que[tail].y = sy;
		que[tail].step = 0;
		tail++;
		book[sx][sy] = 1;

		while (head < tail) {
			for (int k = 0; k <= 3; k++) {
				tx = que[head].x + next[k][0];
				ty = que[head].y + next[k][1];
				if (tx < 1 || tx > n || ty < 1 || ty > m) {// 判断是否出了地图
					continue;
				}
				if (a[tx][ty] == 0 && book[tx][ty] == 0) {// 判断是否走过和有无障碍物
					System.out.println(tx+" "+ty);
					book[tx][ty] = 1;// 下一步可以走 标记走过
					que[tail].x = tx;
					que[tail].y = ty;
					que[tail].step = que[head].step + 1;// 下一步 是父亲步数+1
					tail++;// 入队延长队列
				}
				if (tx == px && ty == py) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
			head++;
		}
		System.out.println(que[tail-1].step);
	}
}

class Que {
	 int x;
	 int y;
	 int step;
}