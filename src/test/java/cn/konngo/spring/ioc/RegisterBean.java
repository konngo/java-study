package cn.konngo.spring.ioc;

public class RegisterBean {
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * 通过BeanDefinition注入
	 */
	public void testBeanDefinition() {
		BeanFactory beanFactory = new BeanFactory();
		BeanDefinition definition = new BeanDefinition();
		definition.setBeanClass(TestBean.class);
		beanFactory.registerBeanDefinition("myBean",definition);
		Object o =beanFactory.getBean("myBean");
		System.out.println(o);
	}
	
	/**
	 * 测试单例bean的注册和注入
	 */
	public void testResgister() {
		BeanFactory beanFactory = new BeanFactory();
		TestBean bean = new TestBean();
		beanFactory.registerSingleton("myBean", bean);
		beanFactory.registerSingleton("myBean", bean);
		beanFactory.myRegister();
		System.out.println("==============");
		Object o =beanFactory.getBean("myBean");
		System.out.println(o);
	}
}
