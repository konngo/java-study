package cn.konngo.spring.shiro;

import java.util.Map;


public class ThreadContext {
	private static final String SECURTY_MANAGER = "securitymanager";
	private static final String SUBJECT = "subject";
	
    private static final ThreadLocal<Map<Object, Object>> resources = new ThreadLocal<Map<Object, Object>>();
    
    
    // 绑定当前Subject
    public static void bind(Subject subject) {
        if (subject != null) {
            put(SUBJECT, subject);
        }
    }

	public static Subject getSubject() {
        return (Subject) get(SUBJECT);
	}
    
	// 获取当前线程下的SecurityManager
    public static SecurityManager getSecurityManager() {
        return (SecurityManager) get(SECURTY_MANAGER);
    }
    
    // 获取指定资源
    public static Object get(String key){
    	return resources.get().get(key);
    }
    
    public static void put(String key,Object Object){
    	resources.get().put(key, Object);
    }
}
