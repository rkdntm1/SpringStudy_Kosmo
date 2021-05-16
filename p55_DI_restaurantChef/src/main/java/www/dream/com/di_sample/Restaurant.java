package www.dream.com.di_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class Restaurant {
	@Autowired @Getter //의존성 주입 
	private Chef chef;

}
