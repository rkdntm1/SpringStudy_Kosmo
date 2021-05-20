package www.dream.com.party.model;

import java.util.Date;

import lombok.Data;
import www.dream.com.common.model.CommonMngVO;

@Data
public class Party extends CommonMngVO {
	private String userId;	//로그인 ID
	private String userPwd;	//암호, 암호화는 나중에
	private	String name;	
	private	Date birthDate;	//생일 년월일
	private	boolean male; //남녀구분
	private	boolean enabled;//가입중... 탈퇴시 faㅣse
	
}
