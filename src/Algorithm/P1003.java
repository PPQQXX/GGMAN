package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class P1003{
    //升序排列
    public static void sortAscend(Integer[] a){
        Arrays.sort(a, new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
                    return a.compareTo(b);
                }
           });
    }
   //降序排列，如果b.compareTo(a)>0,则compare方法根据其返回值认为a>b,与自然比较结果相反
    public static void sortDescend(Integer[] a){
        Arrays.sort(a, new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
                    return b.compareTo(a);
                }
           });
    }   
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7,8,9,10};
        //升序排列
        sortAscend(a);
        for(int num:a)
            System.out.print(num+" ");
        //降序排列
        sortDescend(a);
        System.out.println();
        for(int num:a)
            System.out.print(num+" ");

    }
}