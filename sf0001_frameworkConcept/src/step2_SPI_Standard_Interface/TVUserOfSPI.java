package step2_SPI_Standard_Interface;

public class TVUserOfSPI {
	public static void main(String[] args) {
		TV tv = new LTVAdapter();
		tv.powerOn();
	}
}
