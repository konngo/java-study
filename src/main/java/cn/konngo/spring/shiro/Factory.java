package cn.konngo.spring.shiro;

public class Factory {
	// ά����һ������securityManager����
    private SecurityManager singletonInstance;
    
    // ����ģʽ����SecurityManager
    public SecurityManager getInstance() {
    	if (this.singletonInstance == null) {
          this.singletonInstance = createSecurityManager();
        }
        return this.singletonInstance;
    }
    
    // ���ݲ�ͬ�ķ�ʽ��ȡSecurityManager 
    // ����д��
    public SecurityManager createSecurityManager() {
    	return new SecurityManager();
    }
}
