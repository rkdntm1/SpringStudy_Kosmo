package www.dream.com.di_sample;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml") //여기에 들어있는정보를바탕으로 객체를 만들어라 junit아
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDI {
	@Autowired
	private Restaurant restaurant;
	
	@Autowired
	private Hotel hotel;
	
	@Test
	public void test() {
		restaurant.getChef().setName("홍길동");
		assertNotNull(restaurant);
		System.out.println(restaurant.getChef()); //context에 올라와있는 객체대상으로 autowired할때 같은객체에 하는건지 새롭게 만들어진 객체에 들어가는건지 = > 같은 객체로 엮어줌
	}
	
	@Test
	public void testHotel() {
		assertNotNull(hotel);
		System.out.println(hotel.getChef());
	}

}
