package cn.konngo.spring.ioc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OriginRegisterBean {
	public static void main(String[] args) {
		DefaultListableBeanFactory app = new DefaultListableBeanFactory();
		

	//	BeanDefinition definition = new BeanD
		GenericBeanDefinition definition =new GenericBeanDefinition();
		definition.setBeanClass(TestBean.class);
		app.registerBeanDefinition("bean", definition);
		Object object = app.getBean("bean");
		System.out.println(object);
	}
}
