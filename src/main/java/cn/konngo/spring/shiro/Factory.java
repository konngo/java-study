package cn.konngo.spring.shiro;

public class Factory {
	// 维护了一个单例securityManager对象
    private SecurityManager singletonInstance;
    
    // 懒汉模式创建SecurityManager
    public SecurityManager getInstance() {
    	if (this.singletonInstance == null) {
          this.singletonInstance = createSecurityManager();
        }
        return this.singletonInstance;
    }
    
    // 根据不同的方式获取SecurityManager 
    // 这里写死
    public SecurityManager createSecurityManager() {
    	return new SecurityManager();
    }
}
