package Algorithm;

import java.util.Scanner;

import javax.sound.sampled.TargetDataLine;

/*
 *�Ƚ�DFS_2
 *
 *һ������que[2501]
 *a[][]��ͼ
 *book[][]���
 */
public class BFS_1 {
	public static int sx, sy, px, py;// ��ʼ�����꣬Ŀ�������
	public static int n, m;// n��m��
	// ���������ֱ�Ӱ�n��m�����飬������û���룬Ĭ��ֵΪ0,,,ʵ������Ч
	public static Que[] que = new Que[2501]; // ����
	public static int head, tail; // ͷ�����ĺ���
	public static int[][] book = new int[51][51];// ���
	public static int[][] a = new int[51][51];// ��ά�����ʾͼ
	public static int[][] next = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// �ұ߿�ʼ ˳ʱ����ת4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int flag = 0;
		int tx = 0, ty = 0;
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

		// ���г�ʼ��
		head = 1;
		tail = 1;
		que[tail].x = sx;
		que[tail].y = sy;
		que[tail].step = 0;
		tail++;
		book[sx][sy] = 1;

		while (head < tail) {
			for (int i = 0; i <= 3; i++) {
				tx = que[head].x + next[i][0];
				ty = que[head].y + next[i][1];
				// �õ��µĵ㣬�жϺϷ���
				// �ж��Ƿ�Խ��
				if (tx < 1 || tx > n || ty < 1 || ty > m)
					continue;
				if (a[tx][ty] == 0 && book[tx][ty] == 0)// 1��ʾ�߲�ͨ,0��ʾͨ
				{
					book[tx][ty] = 1;
					que[tail].x = tx;
					que[tail].y = ty;
					que[tail].step = que[head].step + 1;
					tail++;
				}
				if (tx == px && ty == py) {
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				break;
			head++;
		}
		System.out.println(flag);
		System.out.println(que[head].step);
	}
}

class Que {
	static int x=0;
	static int y=0;
	static int step=0;
}