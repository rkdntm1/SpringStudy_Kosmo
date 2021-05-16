package www.dream.com.party.model;

public enum ContactPointType {
	addr("adsad"), phoneNum("qweasd"), mobileNum("dawds");
	
	private String validatingRegEx; // 검사 유효성 검사 용도 정규식
	
	private ContactPointType(String validatingRegEx) {
		this.validatingRegEx = validatingRegEx;
	}
}
	
