package Algorithm;

import java.io.IOException;
import java.util.Scanner;


public class P1177 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// int[] array=new int[10];
		int n;
		int i;
/*		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());*/
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		int[] array=new int[n];
		for (i = 0; i < n; i++) {
//			array[i]=Integer.parseInt(bf.readLine());
			array[i]=reader.nextInt();
		}
		quickSort(array, 0, n-1);
		for (i = 0; i < n-1; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println(array[i]);
		System.out.println();

	}

	private static void quickSort(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		int i, j, t, temp;
		if (l > r) {
			return;
		}
		temp = a[l];
		i = l;// 左
		j = r;// 右
		while (i != j) {
			while (a[j] >= temp && i < j) 
				j--;
				while (a[i] <= temp && i < j) 
					i++;
			if(i<j)
			{
				t=a[j];
				a[j]=a[i];
				a[i]=t;
			}
		}
		//将基数归位
		a[l]=a[i];
		a[i]=temp;
		
		quickSort(a, l, i-1);//zuo digui 
		quickSort(a, i+1, r);// you digui
	}
}