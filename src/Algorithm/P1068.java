/*可以在每个文件的开始处，大致描述一下该类的功能和实现方法，比如这里就是一个treemap的应用，实现成绩的输入和输出，这里可以思考，为什么要用treeMap呢，普通的hashmap行不行呢*/
package Algorithm;

import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/*
code review:class name的命名不合适，可能是和书上保持一致，那么可以命名成TreeMapPracticeP1068之类的，这样一看类名就知道这个类是什么功能
*/
public class P1068 {
	public static void main(String[] args) {
		int grade, size;//输出成绩，人数
		int k,v;//参数命名无实际含义，代码可读性差，读的时候还要思考k和v是什么，而且很容易读着读着就忘了,所以这里用key和value会好一点
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
