package www.dream.com.sample;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.dream.com.sample.model.SVO4Debugging;
import www.dream.com.sample.model.SampleMasterVO;
import www.dream.com.sample.model.SampleVO;

@Controller //Servlet Component로 Container에 담기기위해서는 우리가 어디를 더 보고 확인해야하나요?
//-> Servlet.xml을 확인합시다
@RequestMapping("/sample/*")
public class SampleController {
	/**
	 * sample/ 부르면 작동
	 */
	@RequestMapping("")
	public void basic() {
		System.out.println("basic()을 실행하는군");
	}
	
	/**
	 * sample/gp를 GET 또는 POST방식으로 부르면 작동
	 */
	@RequestMapping(value="gp", method= {RequestMethod.GET, RequestMethod.POST})
	public void basic4getAndPost() {
		System.out.println("basic()을 실행하는군");
	}
	
	/**
	 * sample/get을 GET으로 부르면 작동
	 */
	@GetMapping(value="get")
	public void basic4getOnly() {
		System.out.println("basic4getOnly()을 실행하는군");
	}
	
	/**
	 * sample/post를 POST으로 부르면 작동
	 */
	@PostMapping(value="post")
	public void basic4postOnly() {
		System.out.println("basic4postOnly()을 실행하는군");
	}
	
	/**
	 * sample/param을 GET 방식으로 부를 떄 작동하면서 인자(name, age)까지 변수로
	 * 자동 형변환해 줍니다. 
	 */
	@GetMapping(value="param")
	public void basic4SampleVO(@RequestParam("name") String name, @RequestParam("ag") int age) {
		System.out.println("name =" + name);
		System.out.println("age =" + age);
	}
	
	/**
	 * sample/vo를 GET 방식으로 부를 때 작동하면서 인자와 객체 속성 이름을 짝지어서 객체까지 만들어줍니다.
	 */
	@GetMapping(value="vo")
	public void basic4SampleVO(SampleVO obj) {
		System.out.println(obj);
	}
	
	@GetMapping(value="vo4d")
	public void basic4SVO4Debugging(SVO4Debugging obj) {
		System.out.println(obj);
	}
	
	/**
	 * List<String> interface로는 객체 생성 못해서 오류가납니다.
	 * @RequestParam("ids")로 지정해주지 않아 List 객체로 맵핑이 안됨
	 */
	@GetMapping(value="list")
	public void basic4List(@RequestParam("ids") ArrayList<String> ids) {
		for (String str : ids) {
			System.out.println(str);
		}
	}
	
	/**
	 * 배열의 경우 동일 이름이 @RequestParam이 없어도 구동되니까 더욱 편리함.
	 */
	@GetMapping(value="arr")
	public void basic4Array(@RequestParam("ids") String[] ids) {
		for (String str : ids) {
			System.out.println(str);
		}
	}
	
	/**
	 * ~/sample/masterDetail?id=0001&listSampleVO%5B0%5D.name=홍길동&listSampleVO%5B0%5D.age=555&listSampleVO%5B1%5D.name=이순신&listSampleVO%5B1%5D.age=333
	 */
	@GetMapping(value="masterDetail")
	public void basic4masterDetail(SampleMasterVO obj) {
		System.out.println(obj);
	}
}
