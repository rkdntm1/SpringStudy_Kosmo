package www.dream.com.common.model;

import java.util.Date;

import lombok.Data;

@Data
public abstract class CommonMngVO {
	private Date registrationDate; //등록 시점 
	private Date updateDate; //수정시점
}
