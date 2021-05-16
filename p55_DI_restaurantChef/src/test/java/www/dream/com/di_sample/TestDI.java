package www.dream.com.di_sample;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit이 객체를 불러서 test
//어디에서 로드할지를 알려줌
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml") //여기에 들어있는정보를바탕으로 객체를 만들어라 junit아
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDI {
	@Autowired
	private Restaurant restaurant;
	
	@Autowired
	private Hotel hotel;
	
	@Test
	public void test() {
		//context에 객체가 만들어졌을때 그 해당객체가 재사용되는지 신규생성되는지 확인하자 -> 결과 기본은 singleton이라 같은 것이로 엮여짐
		restaurant.getChef().setName("홍길동");
		assertNotNull(restaurant); //객체가 들어있음을 보장
		System.out.println(restaurant.getChef()); 
	}
	
	@Test
	public void testHotel() {
		assertNotNull(hotel);
		System.out.println(hotel.getChef());
	}

}
