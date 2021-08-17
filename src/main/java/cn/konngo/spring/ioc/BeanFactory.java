package cn.konngo.spring.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;



public class BeanFactory extends BeanRegistry{
	
	// 保存所有的beanDefinition
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
	
	
	
	
	/**
	 * 根据name获取指定bean对象
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		// 如果当前是单例bena对象
		Object bean = getSingleton(name);
		
		// 根据BeanDefinition创建bean对象
		if (bean == null) {
			
		}
		return bean;
	}
	
	/**
	 *  根据实例创建Bean对象
	 */
	public Object getObjectFromFactoryBean(
			FactoryBean factory,String beanName){
		
		return null;
	}
	
	/**
	 * 注册单例模式的bean对象到ioc容器中
	 */
	public void registerSingleton(String name, Object bean) {
		super.registerSingleton(name,bean);
	}
	
	/**
	 * 将beanDefition添加到map中
	 */
	public void registerBeanDefinition(String name,BeanDefinition definition) {
		this.beanDefinitionMap.put(null, definition);
	}
}
