package Algorithm;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 *  首次排序，以后每一次看结果插入？
 */
public class 贪心P1090_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();//使用list来存储每堆的重量

        for (int i = 0; i < n; i++) {//读入数据
            list.add(in.nextInt());
        }

        Collections.sort(list);//使用sort排序

        int temp = 0, sum = 0;//temp表示合并最小的两堆后的重量,sum表示用掉的总体力

        while (list.size() >= 2) {
            //取最小的两堆,随后把这两堆移除
            temp = list.get(0) + list.get(1);
            sum = sum + temp;
            list.remove(0);
            list.remove(0);

            if (list.size() == 0)
                break;
            if (temp >= list.get(list.size() - 1)) {//如果合并之后的堆重量比list中最大的堆重,插入在末尾
                list.add(temp);
            } else if (temp <= list.get(0)) {//如果合并之后的队比list中最小的要小,插入在最前面
                list.add(0, temp);
            } else {
                insert(list, temp);//其他位置的插入
            }
        }
        System.out.println(sum);

    }

    static void insert(ArrayList<Integer> list, int temp) {//把temp插入在list中的合适位置
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= temp && temp <= list.get(i + 1)) {
                list.add(i + 1, temp);
                break;
            }
        }
    }
}