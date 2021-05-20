package www.dream.com.party.persistence;

import java.util.List;

import www.dream.com.party.model.Party;

/**
 * Mybatis를 활용하여 Party 종류의 객체를 관리하는 인터페이스
 * @author YongHoon Kim
 */
public interface PartyMapper {
	public List<Party> getList(); //table에 들어있는 모든 정보
}
