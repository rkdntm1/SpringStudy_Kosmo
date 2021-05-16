package www.dream.com.party.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import www.dream.com.party.model.Party;

@Controller //Servlet Component로 Container에 담기기위해서는 우리가 어디를 더 보고 확인해야하나요?
//-> Servlet.xml을 확인합시다
@RequestMapping("/party/*")
public class PartyController {
	/**
	 * party/registerParty를 호출하면 회원가입화면 열기
	 */
	@GetMapping(value="registerParty") 
	public void openregisterPartyView() {
		System.out.println("openRegisterPartyView");
	}
	
	/**
	 * Master-Detail 관계. 1:N관계
	 * party/createParty를 Post 방식으로 부를때 작동하면서 인자와 객체 속성 이름을  짝지어주고 또한
	 * 객체 내부의 객체까지 만들어 줍니다.
	 */
	@PostMapping(value="createParty")
	public void createParty(Party obj) {
		System.out.println(obj);
	}
}
