package Algorithm;

import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P1068 {
	public static void main(String[] args) {
		int grade, size;//输出成绩，人数
		int k,v;
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();//参与人数
		int m = reader.nextInt();//成绩下表
		int num = (int) (m * 1.5 * 10 / 10);//向下取整
		//定义treemap
		Map<Integer, Integer> map=new TreeMap<Integer,Integer>();
		for (int i = 0; i < n; i++) {
			k=reader.nextInt();
			v=reader.nextInt();
			map.put(k, v);
		}
		Iterator iterator=map.keySet().iterator();
		while (iterator.hasNext()) {
			int key=(int) iterator.next();
			System.out.println(key+" "+map.get(key));
		}
	}
}