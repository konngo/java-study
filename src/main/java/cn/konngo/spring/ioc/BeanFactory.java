package cn.konngo.spring.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletResponse;



public class BeanFactory extends BeanRegistry{
	
	// �������е�beanDefinition
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);
	
	
	
	
	/**
	 * ����name��ȡָ��bean����
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		// �����ǰ�ǵ���bena����
		Object bean = getSingleton(name);
		
		// ����BeanDefinition����bean����
		if (bean == null) {
			
		}
		return bean;
	}
	
	/**
	 *  ����ʵ������Bean����
	 */
	public Object getObjectFromFactoryBean(
			FactoryBean factory,String beanName){
		
		return null;
	}
	
	/**
	 * ע�ᵥ��ģʽ��bean����ioc������
	 */
	public void registerSingleton(String name, Object bean) {
		super.registerSingleton(name,bean);
	}
	
	/**
	 * ��beanDefition��ӵ�map��
	 */
	public void registerBeanDefinition(String name,BeanDefinition definition) {
		this.beanDefinitionMap.put(null, definition);
	}
}
