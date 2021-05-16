package www.dream.com.sample.model;

public class SVO4Debugging {
	private String name;
	private int age;
	
	public SVO4Debugging() {
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SVO4Debugging [name=" + name + ", age=" + age + "]";
	}
}
