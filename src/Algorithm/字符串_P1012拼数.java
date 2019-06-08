package Algorithm;

import java.util.Scanner;
//实际上就是一个排序

/*
题目描述
设有nn个正整数(n≤20)(n≤20)，将它们联接成一排，组成一个最大的多位整数。

例如：n=3n=3时，33个整数1313,312312,343343联接成的最大整数为：3433121334331213
又如：n=4n=4时，44个整数77,1313,44,246246联接成的最大整数为：74246137424613*/
public class 字符串_P1012拼数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n; // 总数n <=20
		n = in.nextInt();
		String[] s = new String[n]; // 保存字符串
		for (int i = 0; i < s.length; i++) {
			s[i] = in.next();
		}
		in.close();
		// s.compareTo() 注意string比大小不能用<,>  使用compareTo
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].compareTo(s[j]) < 0)  //逆序排序
					swap(s, i, j);
			}
		}
		String string="";
		
		for (int i = 0; i < s.length; i++) {	
			string+=s[i];
		}
		System.out.println(string);
	}

	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}