package cn.konngo.spring.ioc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;

/**
 * @author konngo
 *
 */
public class BeanRegistry {
	// 用来存储spring中所有bean对象
	private final  Map<String,Object> singletonObjects = new ConcurrentHashMap<String, Object>();
	// 用来存储bean对象的工厂类
	private final  Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>(16);
	
	/**
	 * 注册bean对象到ioc容器
	 * @param name
	 * @param bean
	 */
	public void registerSingleton(String name, Object bean) {
		if(bean == null) {
			// 不允许bean对象为空
			System.out.println("bean对象不能为空");
			return ;
		}
		if (this.singletonObjects.get(name) != null) {
			System.out.println("已经存在bean对象:"+name+",不允许重复bean对象");
			return;
		}

		addSingleton(name,bean);
	}
	
	/**
	 * 获取单例bean对象
	 * @param name bean名
	 * @return
	 */
	public Object getSingleton(String name){
		Object bean = this.singletonObjects.get(name);
		return bean!=null?bean:null;
	}
	
	/**
	 * 采用饿汉模式注册单例对象
	 * @param name
	 * @param bean
	 */
	public void addSingleton(String name, Object bean) {
		// 加同步锁
		synchronized (this.singletonObjects) {
			this.singletonObjects.put(name, bean);
			this.singletonFactories.remove(name);
		}
		
	}
	
	// 测试工具，主要用于输出当前容器内容
	public void myRegister() {
		System.out.println(this.singletonObjects);
		System.out.println(this.singletonFactories);
	}
}
