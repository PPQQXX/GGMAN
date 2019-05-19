package Algorithm;


import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
/*
 *    bufferedInputStream  不了解
 *    Collections
 *    Vector  Collection -->1.List 2.Set  3.Vector
 *    2019年5月19日 11:42:40
 */

class Student1 {
    static int moneyAll;
    String name;// 学生姓名
    int no;// 输入顺序编号
    int exam = 0;// 期末平均成绩
    int examClass = 0;// 班级评议成绩
    boolean isS = false;// 是否是学生干部
    boolean isW = false;// 是否是西部省份学生
    int num = 0;// 发表论文数量
    int money = 0;// 获得的奖学金

   //读入的同时可以判断完毕 
    void function() {// 判断学生获得多少奖学金
        if (this.exam > 80 && this.num > 0)
            this.money = this.money + 8000;
        if (this.exam > 85 && this.examClass > 80)
            this.money = this.money + 4000;
        if (this.exam > 90)
            this.money = this.money + 2000;
        if (this.isS && this.examClass > 80)
            this.money = this.money + 850;
        if (this.isW && this.exam > 85)
            this.money = this.money + 1000;
        moneyAll = moneyAll + this.money;//计算奖学金的总数
    }
}

public class P1051 {

    static Comparator<Student1> com = new Comparator<Student1>() {// 重写比较器

        @Override
        public int compare(Student1 o1, Student1 o2) {
            // 按照money的多少进行排序
            int m1 = o1.money;
            int m2 = o2.money;
            if (m1 < m2)
                return 1;
            if (m1 > m2)
                return -1;
            if (m1 == m2) {// 如果money的大小相同,则按照输入顺序进行排序
                int no1 = o1.no;
                int no2 = o2.no;
                if (no1 < no2)
                    return -1;
                if (no1 > no2)
                    return 1;
            }
            return 0;
        }
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        Vector<Student1> num = new Vector<>();// 存储所有学生信息的数组
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            Student1 s = new Student1();
            s.no = i;// 学生编号
            s.name = scan.next();// 学生姓名
            s.exam = scan.nextInt();// 学生期末成绩
            s.examClass = scan.nextInt();// 班级评议成绩
            if (scan.next().equals("Y"))// 是否是学生干部
                s.isS = true;
            if (scan.next().equals("Y"))// 是否是西部省份学生
                s.isW = true;
            s.num = scan.nextInt();// 发表论文数量
            s.function();// 计算每位学生的奖金
            num.add(s);
        }
        scan.close();
        Collections.sort(num, com);// sort排序

        System.out.println(num.get(0).name);
        System.out.println(num.get(0).money);
        System.out.println(Student1.moneyAll);
    }
}