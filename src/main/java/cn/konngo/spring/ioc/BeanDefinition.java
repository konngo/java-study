package cn.konngo.spring.ioc;

public class BeanDefinition {
	// bean对象类型
	private volatile Object beanClass;
	// 作用域
	private String scope = "";
	// 工厂类名
	private String factoryBeanName;
	
	// 设置bean对象类型
	public void setBeanClass(Class clazz) {
		this.beanClass = clazz;
	}
	
	// 设置bean工厂类
	public void setFactoryBeanName(String name) {
		this.factoryBeanName = name;
	}
}
