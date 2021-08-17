package cn.konngo.spring.shiro;


/**
 * Ö÷Ìâ
 * @author konngo
 *
 */
public class Subject {
	
	
	public static class Builder {
        private final SubjectContext subjectContext;

        private final SecurityManager securityManager;
        
        public Builder() {
            this(SecurityUtils.getSecurityManager());
        }
        
        public Builder(SecurityManager securityManager) {
            if (securityManager == null) {
                throw new NullPointerException("SecurityManager method argument cannot be null.");
            }
            this.subjectContext = newSubjectContextInstance();
            this.securityManager = securityManager;
            this.subjectContext.setSecurityManager(securityManager);
        }
        
        protected SubjectContext newSubjectContextInstance() {
            return new SubjectContext();
        }

		
		public Subject buildSubject(){
			return new Subject();
		}
	}
	
}
