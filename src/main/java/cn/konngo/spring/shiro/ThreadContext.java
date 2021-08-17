package cn.konngo.spring.shiro;

import java.util.Map;


public class ThreadContext {
	private static final String SECURTY_MANAGER = "securitymanager";
	private static final String SUBJECT = "subject";
	
    private static final ThreadLocal<Map<Object, Object>> resources = new ThreadLocal<Map<Object, Object>>();
    
    
    // �󶨵�ǰSubject
    public static void bind(Subject subject) {
        if (subject != null) {
            put(SUBJECT, subject);
        }
    }

	public static Subject getSubject() {
        return (Subject) get(SUBJECT);
	}
    
	// ��ȡ��ǰ�߳��µ�SecurityManager
    public static SecurityManager getSecurityManager() {
        return (SecurityManager) get(SECURTY_MANAGER);
    }
    
    // ��ȡָ����Դ
    public static Object get(String key){
    	return resources.get().get(key);
    }
    
    public static void put(String key,Object Object){
    	resources.get().put(key, Object);
    }
}
