package Algorithm;
	import java.util.Arrays;
	import java.util.Scanner;
public class 字符串P1603 {
	public static String zhi(String []arr) {
	    int sum=6;
	    int result=0;
	    StringBuilder v=new StringBuilder();
	    for(int i=0;i<arr.length-1;i++) {
	    switch (arr[i]) {
	    case "one":result=1;break;case "two":result=4;break;
	    case "three":result=9;break;case "four":result=16;break;
	    case "five":result=25;break;case "six":result=36;break;
	    case "seven":result=49;break;case "eight":result=64;break;
	    case "nine":result=81;break;case "ten":result=0;break;
	    case "eleven":result=21;break;case "twelve":result=44;break;
	    case "thirteen":result=69;break;case "fourteen":result=96;break;
	    case "fifteen":result=25;break;case "sixteen":result=56;break;
	    case "seventeen":result=89;break;case "eighteen":result=24;break;
	    case "nineteen":result=61;break;case "twenty":result=0;break;
	    case "a":result=1;break;case "both":result=4;break;
	    case "another":result=1;break;case "first":result=1;break;
	    case "second":result=4;break;case "third":result=9;break;
	    case "zero":result=0;break;
	    default:
	        //每一次如果这个单词不表示数字，那么就应该把result置0
	        result=0;
	        break;
	    }
	    if(result!=0) {
	        v.append(result+" ");
	    }
	    else {
	        sum--;
	    }
	    }
	    if(sum==0)return "0";
	    return v.toString();        
	}
	    public static void main(String[] args) {
	        Scanner in=new Scanner(System.in);
	        String s=in.nextLine();
	        String[]arr=s.split(" ");
	        String[]num=zhi(arr).split(" ");
	        int []shu=new int[num.length];
	        for(int i=0;i<shu.length;i++) {
	            shu[i]=Integer.parseInt(num[i]);
	        }
	        Arrays.sort(shu);
	        StringBuilder v=new StringBuilder();
	        v.append(shu[0]);
	        for(int i=1;i<shu.length;i++) {
	            v.append(String.format("%02d", shu[i]));
	    }
	        System.out.println(v.toString());
	  }
}
