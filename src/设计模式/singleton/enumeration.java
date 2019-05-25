package 设计模式.singleton;

/*
 * enum是个啥 5.25
 */
public enum enumeration {
	/* 定义一个枚举的元素，它就代表了Singleton的一个实例。 */

	INSTANCE;
	
	/**
	 * 单例可以有自己的操作
	 */
	public void singletonOperation() {
		// 功能处理
	}
}
/*
 优点： – 实现简单 – 枚举本身就是单例模式。由JVM从根本上提供保障！
 避免通过反射和反序列化的漏洞！ 
 • 缺点： – 无延迟加载
*/