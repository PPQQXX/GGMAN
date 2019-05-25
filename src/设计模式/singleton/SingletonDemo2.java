package 设计模式.singleton;

/*
 * 这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class SingletonDemo2 {
	private static SingletonDemo2 s;
	
	private SingletonDemo2() {
		// TODO Auto-generated constructor stub
	};
	
	@SuppressWarnings("unused")
	private static  SingletonDemo2 getInstance() {//注意此处缺少synchronized
		if (s==null) {
			s=new SingletonDemo2();//延迟加载
		}
		return s;
	}
}
