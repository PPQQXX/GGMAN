package 设计模式.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	/*	enumeration s1 = enumeration.INSTANCE;
		enumeration s2 = enumeration.INSTANCE;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);*/

		// 通过反射的方式直接调用私有构造器
		Class<SingletonDemo1> clazz = (Class<SingletonDemo1>) Class.forName("设计模式.singleton.SingletonDemo1");
		Constructor<SingletonDemo1> c = clazz.getDeclaredConstructor();
		c.setAccessible(true);// 不检查 可以直接访问到私有
		SingletonDemo1 s3 = c.newInstance();
		SingletonDemo1 s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);
		// 通过反射的方式直接调用私有构造器
		Class<SingletonDemo1_2> clazz1 = (Class<SingletonDemo1_2>) Class.forName("设计模式.singleton.SingletonDemo1");
		Constructor<SingletonDemo1_2> c1 = clazz1.getDeclaredConstructor();
		c1.setAccessible(true);// 不检查 可以直接访问到私有
		SingletonDemo1_2 s31 = c1.newInstance();
		SingletonDemo1_2 s41 = c1.newInstance();
		System.out.println(s31);
		System.out.println(s41);

		// 通过反序列化的方式构造多个对象
		/*
		 * FileOutputStream fos = new FileOutputStream("d:/a.txt"); ObjectOutputStream
		 * oos = new ObjectOutputStream(fos); oos.writeObject(s1); oos.close();
		 * fos.close();
		 * 
		 * ObjectInputStream ois = new ObjectInputStream(new
		 * FileInputStream("d:/a.txt")); SingletonDemo6 s3 = (SingletonDemo6)
		 * ois.readObject(); System.out.println(s3);
		 */
	}

}
