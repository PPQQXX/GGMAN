package Algorithm;

import java.util.Iterator;

/*
 * 				最短路径
 * Floyd，    		Dijkstra，		Bellman
 * O(n^3)     	O((M+N)logN)		O(MN)
 */
class Short {
	final static int INF = Integer.MAX_VALUE;

	public void Flyod(int[][] e) {
		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < e.length; j++) {
				for (int j2 = 0; j2 < e.length; j2++) {
					if (e[j][j2] > e[j][i] + e[i][j2] && e[i][j2] < INF && e[j][i] < INF) {
						e[j][j2] = e[j][i] + e[i][j2];
					}
				}
			}
		}
		for (int[] row : e) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}

	//答案错误
	public void Dijkstra(int[][] e) {
		// 求一号点到其他点
		int min=INF, tem = 1;
		int[] book = new int[e.length];
		int[] dis = new int[e.length];
		// 初始化dis
		for (int i = 0; i < dis.length; i++) {
			dis[i] = e[0][i];
		}
		//初始化book
		for (int i = 0; i < book.length; i++) {
			book[i] = 0;
		}
		
		book[0] = 1;
		for(int i=0; i<e.length; i++) {
	         min=INF;
	        for(int j=0; j<e.length; j++) {
	            if(book[j]==0&&dis[j]<min) {
	                min=dis[j];
	                tem=j;
	            }
	        }
	        book[tem]=1;
	        for(int k=0; k<e.length; k++) {//松弛
	            if(e[tem][k]<e.length) {
	                if(dis[k]>dis[tem]+e[tem][k]) {
	                    dis[k]=dis[tem]+e[tem][k];
	                }
	            }
	        }
	    }
		for (int i = 0; i < dis.length; i++) {
			System.out.print(dis[i]+" ");
		}
	}
}

public class Floyd_Warshall {
	final static int INF = Integer.MAX_VALUE;
	static int[][] e = { { 0, 2, 6, 4 }, { INF, 0, 3, INF }, { 7, INF, 0, 1 }, { 5, INF, 12, 0 } };
	static int[][] a = { { 0, 1, 12, INF, INF, INF },
			{ INF, 0, 9, 3, INF, INF }, 
			{ INF, INF, 0, INF, 5, INF },
			{ INF, INF, 4, 0, 13, 15 }, 
			{ INF, INF, INF, INF, 0, 4 }, 
			{ INF, INF, INF, INF, INF, 0 } };

	public static void main(String[] args) {
		Short s = new Short();
		//s.Flyod(e);
		s.Dijkstra(a);
	}
}
