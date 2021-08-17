package cn.konngo.spring.ioc;

public class BeanDefinition {
	// bean��������
	private volatile Object beanClass;
	// ������
	private String scope = "";
	// ��������
	private String factoryBeanName;
	
	// ����bean��������
	public void setBeanClass(Class clazz) {
		this.beanClass = clazz;
	}
	
	// ����bean������
	public void setFactoryBeanName(String name) {
		this.factoryBeanName = name;
	}
}
