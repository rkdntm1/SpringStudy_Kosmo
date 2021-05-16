package www.dream.com.sample.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * VO : Value Object. 값을 담고 있는 객체. 화면에서부터 DB_table까지 활용되는것.
 * ㄴ 인체구조로 비유하자면 : 피
 * DTO : Data Transfer Object 
 */

@NoArgsConstructor
public class SampleVO {
	@Setter
	private String name;
	@Setter
	private int age;
	
	@Override
	public String toString() {
		return "SampleVO [name=" + name + ", age=" + age + "]";
	}
}
