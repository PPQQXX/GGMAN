package Algorithm;

import java.util.Scanner;
/**
 * scanner  中 各种数据读入，，，
 * next 与 nextline区别
 * @author 11869
 *
 */
public class P1781 {
	
	public static void main(String[] args) {
		int n,id;//id 就是第几个出现的
		String max="";
		String p;//输入的票数
		Scanner rd=new Scanner(System.in);
		//总数
		int num;
		num=rd.nextInt();
		//第一个当做max
		max=rd.next();
		n=id=1;
		//其余n-1
		for (int i = 1; i <=num-1; i++) {
			p=rd.next();
			n++;
			/*System.out.println(max+" "+p);
			System.out.println(max.length()+" "+p.length());*/
			if(max.length()<p.length())
			{
				id=n;
				max=p;
			}
			if (max.length()==p.length()) {
				if(max.compareTo(p)<0)
				{
					id=n;
					max=p;
				}
			}
		}
		System.out.println(id);
		System.out.print(max);
	}
}
 