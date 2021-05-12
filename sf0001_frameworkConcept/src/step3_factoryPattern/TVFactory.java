package step3_factoryPattern;

public class TVFactory {
	public static TV getBean(String beanName) {
		if ("STV".equals(beanName)) { 
			return new STV();
		} else if (beanName != null && beanName.equals("LTV")) { 
			// 단점: NullPointerException 발생을 막아야한다.
			return new LTVAdapter();
		} else if ("HTV".equals(beanName)) { 
			return new HTV();
		} else if ("ATV".equals(beanName)) { 
			return new ATV();
		} else {
			return null;
		}
	}
}
