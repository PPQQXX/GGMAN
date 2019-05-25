package 设计模式.singleton;


/*单例模式_饿汉式
 * 
 * 
 * */
public class SingletonDemo1_2{
	private static SingletonDemo1_2 instance = new SingletonDemo1_2(); // 回去看看类加载器 天然线程安全

	private SingletonDemo1_2() {
		if (instance!=null) {
			throw new RuntimeException();
		}
	};// 构造器不能是static

	public static SingletonDemo1_2 getInstance() {
		return instance;
	}

}
