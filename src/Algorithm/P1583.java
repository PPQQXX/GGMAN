package Algorithm;


import java.util.Arrays;
import java.util.Scanner;
/*
                          类类型数组  comparable   Arrays.sort()
10 10
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
 */
public class P1583 {
	static int[] e = new int[11];// 1----10

	public static void main(String[] args) {
		int n, k;
		int di;
		Scanner rd = new Scanner(System.in);

		n = rd.nextInt();
		Man2[] man = new Man2[n];
		k = rd.nextInt();
		// 读入E[i]的权值。
		for (int i = 1; i < e.length; i++) {
			e[i] = rd.nextInt();
		}
		// 读入权重
		for (int i = 0; i <n; i++) {
			man[i] = new Man2(i+1, rd.nextInt());
		}
		rd.close();
		// 自定义的类需要重写comparable
		//不可以含有空的数组元素！！！
		Arrays.sort(man);
		
		for (int i = 0; i < n; i++) {
			 di = (i)%10+1;
			 man[i].wight=man[i].wight+e[di];
		}
		
		Arrays.sort(man);
		int j=1;
		for (Man2 man2 : man) {
			if (j<=k) {
				System.out.print(man2.id);
				if (j<k) {
					System.out.print(" ");
				}
			}
			j++;
		}
	}
}

class Man2 implements Comparable<Man2> {
	// id 权重
	int id;
	int wight;

	public Man2(int id, int wight) {
		this.id = id;
		this.wight = wight;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return wight+" ";
	}
	@Override
	public int compareTo(Man2 o) {
		// TODO Auto-generated method stub
		if (this.wight > o.wight) {
			return -1;
		} else if (this.wight < o.wight) {
			return 1;
		} else {// wight相同就比较id
			if (this.id > o.id) {
				return 1;
			} else if (this.id < o.id) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}