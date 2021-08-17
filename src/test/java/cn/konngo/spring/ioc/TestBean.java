package cn.konngo.spring.ioc;

/**
 * ≤‚ ‘Bean∂‘œÛ
 * @author konngo
 */
public class TestBean {
	private String name = "first bean";
	private String description = "this is my first bean in my ioc container";
	
	public TestBean() {
	}
	
	public TestBean(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Bean [name=" + name + ", description=" + description + "]";
	}
	
	
}
