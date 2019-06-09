package Algorithm;

import java.util.Scanner;

public class 贪心P1181 {
//很奇怪，，，不知道在想什么，就很迷
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n, m;
		int sum = 0;
		int temp=0;
		n = in.nextInt();
		m = in.nextInt();
		int a;//每次读入的数
		for (int i = 0; i < n; i++) {
			a = in.nextInt();
			if(temp+a<=m)
			{
				temp+=a;
			}else {
				sum++;
				temp=a;
			}
		}
		in.close();
		
		System.out.println(sum+1);
	}

}
