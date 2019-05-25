package 设计模式.singleton;

/*               lazy load
 * 懒汉式  单例对象延迟加载
 *资源利用率高，但每次使用getInstance都需要同步，并发效率低
 */
public class SingletonDemo2_2 {
	private static SingletonDemo2_2 s;
	
	private SingletonDemo2_2() {
		// TODO Auto-generated constructor stub
	};
	
	@SuppressWarnings("unused")
	private static synchronized SingletonDemo2_2 getInstance() {
		if (s==null) {
			s=new SingletonDemo2_2();//延迟加载
		}
		return s;
	}
}
