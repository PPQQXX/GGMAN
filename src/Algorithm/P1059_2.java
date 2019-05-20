package Algorithm;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 
 * SET
 * 迭代器输出，直接一路到底，怎么停在前一个呢？
 * @author 11869
 *
 */
public class P1059_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,num=0;
		int []a=new int [100];
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		//set
		Set<Integer> set=new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			num=reader.nextInt();
			a[num]=1;
		}
		reader.close();
		for (int i = 0; i < a.length; i++) {
			/*System.out.print(a[i]+"~");*/
			if(a[i]==1)
				set.add(i);
		}
		System.out.println(set.size());
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer+" ");
		}
	}

}
