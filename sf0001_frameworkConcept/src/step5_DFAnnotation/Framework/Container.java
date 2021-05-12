package step5_DFAnnotation.Framework;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
	private static final Container theInstance = new Container();
	
	private Map<String, Object> mapElements = new HashMap<>();
	
	private Container() {
		prepare();
		injectDependency();
	}

	public static Container getInstance() {
		return theInstance;
	}
	
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
	
	private void injectDependency() {
		for (String key : mapElements.keySet()) {
			// Root_Context.xml에 설정된 데로 만들어 담아 놓은 모든 객체들을 대상으로 
			Object bean = mapElements.get(key);
			for (Field field : bean.getClass().getDeclaredFields()) {
				// 각 객체별 정의된 속성. 모든 것을 대상으로
				AutoWired anno = field.getAnnotation(AutoWired.class);
				if (anno != null) {
					//AutoWired라는 에노테이션(주석, 부가적인 설명정보)이 달려있으면
					System.out.println(field.getName());
					
					Object val = getBean(anno.beanName()); // STV에 달려있는 path객체가 나옴
					try {
						field.setAccessible(true);
						//정보 할당. DI
						field.set(bean, val);
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
		}
	}
}
