package cn.konngo.spring.ioc;

public class RegisterBean {
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * ͨ��BeanDefinitionע��
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
	 * ���Ե���bean��ע���ע��
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
