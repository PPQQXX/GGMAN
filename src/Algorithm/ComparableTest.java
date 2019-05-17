package Algorithm;

import java.util.Set;
import java.util.TreeSet;

public class ComparableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new TreeSet<>();//有序 ，不可重复

		set.add(300);
		set.add(200);
		set.add(600);
		
		// 按照元素递增的方式排好序
		for (Integer m : set) {
			System.out.println(m);
		}

		Set<Emp> set2 = new TreeSet<>();
		set2.add(new Emp(100, "张三", 3000));
		set2.add(new Emp(50, "李四", 2000));
		set2.add(new Emp(150, "王五", 8000));
		set2.add(new Emp(30, "赵六", 20000));

		for (Emp m : set2) {
			System.out.println(m);
		}
	}

}

class Emp implements Comparable<Emp> {
	int id;
	String name;
	double salary;

	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "id:" + id + ",name:" + name + ",salary:" + salary;
	}

	@Override
	public int compareTo(Emp o) { // 负数：小于，0：等于，正数：大于

		if (this.salary > o.salary) {
			return 1;
		} else if (this.salary < o.salary) {
			return -1;
		} else {//salary相同就比较id
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