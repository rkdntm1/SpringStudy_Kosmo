package step4_DreamFramework.Framework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
	Map<String, Object> mapElements = new HashMap<>();
	
	public void prepare() {
		try {
			List<Pair<String, String>> list = ContextParser.parseContext();
			for (Pair<String, String> p : list) {
				//클래스로더를 통해서 해당 클래스를 로드 - 해당 객체(클래스) 찾아서 실행시킬준비를 해줌. 실행준비단계
				Class beanClass = Class.forName(p.getS());
				mapElements.put(p.getF(), beanClass.newInstance()); // 이름과 객체 짝짖기				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String beanName) {
		return mapElements.get(beanName);
	}
}
