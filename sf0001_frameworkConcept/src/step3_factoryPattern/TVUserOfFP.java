package step3_factoryPattern;

public class TVUserOfFP {
	public static void main(String[] args) {
		TV tv = TVFactory.getBean(args[0]);
		tv.powerOn();
	}
}
