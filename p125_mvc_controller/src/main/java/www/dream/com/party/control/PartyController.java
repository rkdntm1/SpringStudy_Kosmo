package www.dream.com.party.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.dream.com.party.model.ContactPoint;
import www.dream.com.party.model.ContactPointType;
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
	public String createParty(Party obj, Model model) {
		System.out.println(obj);
		obj.setId(55);
		model.addAttribute("newbie", obj); //mode-jsp로 정보 넘길떄 사용 newbie: 변수명 , obj: 객체
		/* (java)
		Party newbie = obj;
		retrun newbie
		*/
		return "party/confirmParty";
	}
	
	/**
	 * ModelAndView는 AJax에서 주로 사용합니다. 
	 */
	@PostMapping(value="createPartyByAjax")
	public ModelAndView createPartyByAjax(Party obj) {
		ModelAndView ret = new ModelAndView("party/confirmParty"); //jsp파일 위치
		System.out.println(obj);
		obj.setId(55);
		ret.addObject("newbie", obj); // newbie: 변수명 , obj: 객체
		return ret;
	}
	
	@PostMapping(value="createPartyByDefault")
	//@ModelAttribute로 기본자료형을 화면에 표현해주기 가능해짐 
	public String createPartyByDefault(Party obj, @ModelAttribute("ageOfMine") int ageOfMine) {
		System.out.println(obj);
		System.out.println("내사랑 나이는 "  +ageOfMine);
		obj.setId(56);	
		return "party/confirmParty";
	}
	
	/**
	 * RedirectAttibutes 
	 */
	@PostMapping(value="createPartyByRedirect")
	public String createPartyByRedirect(Party obj, RedirectAttributes rttr) {
		System.out.println(obj);
		obj.setId(56);	
		rttr.addAttribute("newbie", 456); // redirect에서 객체를 newbie에 넣어주려면 뭔가 더 필요하다. 
		
		return "redirect:/party/redirectedParty";
	}
	
	//redirect는 Get 방식으로 재요청 해준다.
	@GetMapping(value="redirectedParty")
	public String confirmPartyByRedirect(@RequestParam("newbie") int id, Model model) {
		System.out.println(id);
		Party obj = new Party();
		obj.setId(57);
		model.addAttribute("newbie", obj);
		
		return "/party/confirmParty";
	}
	
	/**
	 * AJax RestAPI
	 */
	@GetMapping(value="getJson")
	public @ResponseBody Party getJsonOfParty() {	//@ResponseBody 응답의 바디영역에 넣어줘라
		Party obj = new Party();
		obj.setName("홍길동");
		obj.setId(57);

		ContactPoint cp = new ContactPoint();
		cp.setContactPointType(ContactPointType.phoneNum);
		cp.setValue("010-2215-7086");
		obj.addCP(cp);
		
		cp = new ContactPoint();
		cp.setContactPointType(ContactPointType.addr);
		cp.setValue("한양");
		obj.addCP(cp);
		return obj;
	}
}
