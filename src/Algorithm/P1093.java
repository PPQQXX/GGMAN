package Algorithm;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/*
 * 总分从高到低排序，如果两个同学总分相同，再按语文成绩从高到低排序，
 * 如果两个同学总分 和语文成绩都相同，那么规定学号小的同学 排在前面，
 * 这样，每个学生的排序是唯一确定的。
 最后按排名顺序输出前五名名学生的学号和总分。注意，在前5名同学中
 																		oj过不了    莫名其妙，我去掉 package就过去了？
 */
public class P1093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;// 总人数
		int chi, math, eng,sum;// 每次输入的值
		Scanner rd = new Scanner(System.in);
		n = rd.nextInt();
		Set<Student2> set=new TreeSet<Student2>();
		for (int i = 1; i <= n; i++) {
			chi = rd.nextInt();
			math = rd.nextInt();
			eng = rd.nextInt();
			sum=chi+math+eng;//总分
			set.add(new Student2(chi, math, eng, sum, i));
		}
		rd.close();//scannerd  每次都要记得关闭，要不然有
		int flag=1;
		for (Student2 student : set) {
			if (flag<=5) {
				System.out.println(student);
			}
			flag++;
		}
	}
}

class Student2 implements Comparable<Student2> {
	int chi;
	int math;
	int eng;
	int sum;
	int id;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+sum;
	}
	
	public Student2(int chi, int math, int eng, int sum, int id) {
		super();
		this.chi = chi;
		this.math = math;
		this.eng = eng;
		this.sum = sum;
		this.id = id;
	}

	@Override
	public int compareTo(Student2 o) {
		// TODO Auto-generated method stub
		if (this.sum>o.sum) {
			return -1;
		}else if (this.sum<o.sum) {
			return 1;
		}
		else {
			if (this.chi>o.chi) {
				return -1;
			}else if (this.chi<o.chi) {
				return 1;
			}
			else {
				return this.id-o.id;//都可以这样写简化
			}
		}
	}
}