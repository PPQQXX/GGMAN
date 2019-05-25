package 设计模式.singleton;

/*单例模式_饿汉式
 * 
 * 
 * */
public class SingletonDemo1{
	private static SingletonDemo1 instance = new SingletonDemo1(); // 回去看看类加载器 天然线程安全

	private SingletonDemo1() {
	};// 构造器不能是static

	public static SingletonDemo1 getInstance() {
		return instance;
	}

}
