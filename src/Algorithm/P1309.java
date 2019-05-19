package Algorithm;

import java.util.Arrays;

import java.util.Scanner;


/*
 * 第一行是三个正整数N,R ,QN,R,Q,每两个数之间用一个空格隔开，
 * 第二行是2 \times N2×N 个非负整数s_1, s_2, …, s_{2N} 其中 表示编号为i 的选手的初始分数。
 * 
2 4 2 
7 6 6 7 
10 5 20 15 



60
*/
public class P1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, q, r;// 表示有2×N名选手、R 轮比赛，以及我们关心的名次 Q。
		// 其中 si表示编号为i的选手的初始分数。其中 wi表示编号为i 的选手的实力值。

		Scanner rd = new Scanner(System.in);
		n = rd.nextInt();

		int[] si = new int[2 * n];
		int[] wi = new int[2 * n];// c语言可以这样做吗？
		Player[] player = new Player[2 * n];
		q = rd.nextInt();
		r = rd.nextInt();
		// 分别读入si，wi的值
		for (int i = 0; i < 2 * n; i++) {
			si[i] = rd.nextInt();
		}
		for (int i = 0; i < 2 * n; i++) {
			wi[i] = rd.nextInt();
		}
		// 关闭流
		rd.close();
		// 存入类类型数组
		for (int i = 0; i < 2 * n; i++) {
			player[i] = new Player(si[i], wi[i], i + 1);
		}
		// 开始比赛
		Arrays.sort(player);
		for (int j = 0; j < q; j++) {
			for (int i = 0; i < 2 * n; i += 2) {
				if (player[i].value > player[i + 1].value) {
					player[i].score++;
				}
				else {
					player[i+1].score++;
				}
			}
			Arrays.sort(player);
		}
		int i=1;
		for (Player player2 : player) {	
			if (i==r) {
				System.out.print(player2);
				break;
			}
			i++;
		}
	}
}

class Player implements Comparable<Player> {
	int score;// 初始值
	int value;// 实力
	int id;// id

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public Player() {

	}

	public Player(int score, int value, int id) {
		super();
		this.score = score;
		this.value = value;
		this.id = id;
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		if (this.score - o.score > 0) {
			return -1;
		} else if (this.score - o.score < 0) {
			return 1;
		} else {
			if (this.id - o.id > 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}