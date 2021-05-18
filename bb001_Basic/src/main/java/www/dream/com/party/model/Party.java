package www.dream.com.party.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import www.dream.com.common.model.CommonMngVO;

/**
 * 모든 행위자 정보의 공통적인 상위 정보를 담고있는 추상적인 클래스
 * @author YongHoon Kim
 */
@Data
public abstract class Party extends CommonMngVO {
	private String userId;	//로그인 ID
	private String userPwd;	//암호, 암호화는 나중에
	private	String name;	
	private	Date birthDate;	//생일 년월일
	private	boolean isMale; //남녀구분
	private	boolean enabled;//가입중... 탈퇴시 faㅣse
	
	//1 : N 관계에 대한 속성
	private List<ContactPoint> listContactPoint;
	
}
	