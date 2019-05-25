package 设计模式.singleton;


/*
 * 静态内部类实现方式，懒加载 
 * 延时加载 private static final 保证内存中只有一个实例 只能被赋值一次 
 * 兼备了并发高效调用和延迟加载的优势
 */
public class SingletonDemo4 {
	private static class SingletonClassInstanc {
		private static final SingletonDemo4 instance = new SingletonDemo4();
	}

	public static SingletonDemo4 getInstance() {

		return SingletonClassInstanc.instance;
	}

	private SingletonDemo4() {
		// TODO Auto-generated constructor stub
	}
}