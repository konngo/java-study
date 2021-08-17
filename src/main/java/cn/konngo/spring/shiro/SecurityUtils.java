package cn.konngo.spring.shiro;


// 进入当前subject
public class SecurityUtils {

	private static SecurityManager securityManager;
	
	
    public static Subject getSubject() {
        Subject subject = ThreadContext.getSubject();
        if (subject == null) {
           // subject = (new Subject.Builder()).buildSubject();
            ThreadContext.bind(subject);
        }
        return subject;
    }
	
    public static void setSecurityManager(SecurityManager securityManager) {
        SecurityUtils.securityManager = securityManager;
    }
    
    public static SecurityManager getSecurityManager()  {
        SecurityManager securityManager = ThreadContext.getSecurityManager();
        if (securityManager == null) {
            securityManager = SecurityUtils.securityManager;
        }
        return securityManager;
    }
}
