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
	// �����洢spring������bean����
	private final  Map<String,Object> singletonObjects = new ConcurrentHashMap<String, Object>();
	// �����洢bean����Ĺ�����
	private final  Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>(16);
	
	/**
	 * ע��bean����ioc����
	 * @param name
	 * @param bean
	 */
	public void registerSingleton(String name, Object bean) {
		if(bean == null) {
			// ������bean����Ϊ��
			System.out.println("bean������Ϊ��");
			return ;
		}
		if (this.singletonObjects.get(name) != null) {
			System.out.println("�Ѿ�����bean����:"+name+",�������ظ�bean����");
			return;
		}

		addSingleton(name,bean);
	}
	
	/**
	 * ��ȡ����bean����
	 * @param name bean��
	 * @return
	 */
	public Object getSingleton(String name){
		Object bean = this.singletonObjects.get(name);
		return bean!=null?bean:null;
	}
	
	/**
	 * ���ö���ģʽע�ᵥ������
	 * @param name
	 * @param bean
	 */
	public void addSingleton(String name, Object bean) {
		// ��ͬ����
		synchronized (this.singletonObjects) {
			this.singletonObjects.put(name, bean);
			this.singletonFactories.remove(name);
		}
		
	}
	
	// ���Թ��ߣ���Ҫ���������ǰ��������
	public void myRegister() {
		System.out.println(this.singletonObjects);
		System.out.println(this.singletonFactories);
	}
}
