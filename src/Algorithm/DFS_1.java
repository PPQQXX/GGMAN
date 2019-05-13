package Algorithm;

/*
 * n个数的组合
 * 箱子  ---纸牌
 */
public class DFS_1 {
	public static void main(String[] args) {
		int n = 10;
		while (n > 0) {
			for (int i = 0; i < 10; i++) {
				if (i == 5) {
					System.out.print(i + "~~");
					System.out.println();
					break;
				}
				System.out.print(i + " ");
				n=n-1;
			}
		}
	}
}
