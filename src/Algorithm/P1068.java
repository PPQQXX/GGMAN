package Algorithm;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//多看多练
/**
 * comparable 接口
 * compareto规则  
 * 
 * @author 11869
 *
 *输入样例#1： 
6 3 
1000 90 
3239 88 
2390 95 
7231 84 
1005 95 
1001 88
输出样例#1： 
88 5 
1005 95 
2390 95 
1000 90 
1001 88 
3239 88 
 */
public class P1068 {

	public static void main(String[] args) {
		int n, m, mm;// 总人数 ，预招人数
		int id, grade;
		int mgrade = -1;
		Scanner rd = new Scanner(System.in);
		//
		Set<Man> set = new TreeSet<Man>();
		// 读入
		n = rd.nextInt();
		m = rd.nextInt();
		mm = (int) (m * 1.5);
		// 存的是一个对象,类类型的数组
		// 再把这个类存入treeset
		Man[] man = new Man[n];
		for (int i = 0; i < n; i++) {
			id = rd.nextInt();
			grade = rd.nextInt();// 有忘记了，类类型的数组
			man[i] = new Man(id, grade);
			set.add(man[i]);
		}
		rd.close();
		int j = 1;
		for (Man man2 : set) {
			if (mgrade == man2.grade)
				mm++;
			if (j == mm) {
				mgrade = man2.grade;
			}
			j++;
		}
		System.out.println(mgrade + " " + mm);

		j = 1;
		for (Man man2 : set) {
			if (j <= mm)
				System.out.println(man2);
			j++;
		}
	}
}

class Man implements Comparable<Man> {
	int id;
	int grade;

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return id + " " + grade;
	}

	public Man(int id, int grade) {
		this.id = id;
		this.grade = grade;
	}

	@Override
	// 负数：小于，0：等于，正数：大于
	// 要求grade 前面从大到小，相同id小在前面
	public int compareTo(Man o) {
		// TODO Auto-generated method stub
		if (this.grade > o.grade) {
			return -1;
		} else if (this.grade < o.grade) {
			return 1;
		} else {// salary相同就比较id
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