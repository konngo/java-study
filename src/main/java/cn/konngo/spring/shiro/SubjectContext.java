package cn.konngo.spring.shiro;

public class SubjectContext {
    private  SecurityManager securityManager;
    
    public void setSecurityManager(SecurityManager securityManager){
    	this.securityManager = securityManager;
    }
}
