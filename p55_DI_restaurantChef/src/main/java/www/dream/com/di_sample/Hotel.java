package www.dream.com.di_sample;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Repository 
@RequiredArgsConstructor
public class Hotel {
	@NonNull @Getter
	private Chef chef;
	
	/*
	public Hotel(Chef chef) {
		this.chef = chef;
	}
	*/
}
