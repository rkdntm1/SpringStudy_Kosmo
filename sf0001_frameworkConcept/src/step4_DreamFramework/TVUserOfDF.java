package step4_DreamFramework;

import step4_DreamFramework.Framework.Container;

public class TVUserOfDF {
	public static void main(String[] args) {
		Container container = new Container();
		container.prepare();
		TV tv = (TV) container.getBean(args[0]);
		if (tv != null)
			tv.powerOn();
	}
}
