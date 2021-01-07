package cat.handballstats.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlayerGender {
	Masculí,
	Femení,
	Altre;
	
	@JsonCreator
	public static PlayerGender setGender(String genderValue) throws Exception {
		for(PlayerGender gender: values()) {
			if(gender.name().equals(genderValue)) {
				return gender;
			}
		}
		if(genderValue == "") {
			return null;
		} else {
			throw new Exception("Cal proporcionar un gènere de la llita");
		}
	}
}
