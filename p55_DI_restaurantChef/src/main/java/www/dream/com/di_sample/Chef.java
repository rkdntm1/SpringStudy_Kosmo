package www.dream.com.di_sample;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository // = Data
@NoArgsConstructor // 생성자
@Scope("prototype")
public class Chef {
	@Setter @Getter
	private String name = "";
	
	@Override
	public String toString() {
		return "멋진 " + name + "주방장 ㅎㅇ";
	}

}
