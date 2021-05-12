package step5_DFAnnotation;

import step5_DFAnnotation.Framework.AutoWired;
import step5_DFAnnotation.Framework.Container;

public class TVUserOfAnno {
	//DI dependency Injection. 의존성 주입
	@AutoWired(beanName="LTV")
	private TV myTv;
	
	public TVUserOfAnno() {
		
	}

	private void watchTv() {
		myTv.powerOn();
	}
	
	public static void main(String[] args) {
		TVUserOfAnno u = (TVUserOfAnno) Container.getInstance().getBean("TVUserAnno");
		u.watchTv();
	}

}
