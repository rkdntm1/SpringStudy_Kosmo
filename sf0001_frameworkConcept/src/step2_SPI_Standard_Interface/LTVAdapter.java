package step2_SPI_Standard_Interface;
/**
 * 직접은 못바꾸기 때문에 adapter사용하여 변경
 * @author KYH
 *
 */
public class LTVAdapter implements TV {
	private LTV tv = new LTV();

	@Override
	public void powerOn() {
		tv.turnOn();
		
	}
}
