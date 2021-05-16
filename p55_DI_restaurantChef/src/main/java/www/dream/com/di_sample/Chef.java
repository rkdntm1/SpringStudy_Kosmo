package www.dream.com.di_sample;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository //Chef 클래스는 Component(컨테이너에 들어가는 놈)다. 자동으로 객체만들어 담는다.(Data)
@NoArgsConstructor // 생성자
@Scope("prototype") // 불렸을때 새로운 객체로 생성되도록 해줌(기본은 singleton)
public class Chef {
	@Setter @Getter
	private String name = "";
	
	@Override
	public String toString() {
		return "멋진 " + name + "주방장 ㅎㅇ";
	}

}
