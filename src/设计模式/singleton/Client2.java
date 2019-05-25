package 设计模式.singleton;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enumeration s1=enumeration.INSTANCE;
		enumeration s2=enumeration.INSTANCE;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		SingletonDemo1 s3=SingletonDemo1.getInstance();
		SingletonDemo4 s4=SingletonDemo4.getInstance();
		System.out.println(s3);
		System.out.println(s4);
	}

}
