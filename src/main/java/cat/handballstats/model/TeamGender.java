package cat.handballstats.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TeamGender {
	Femení,
	Masculí,
	Mixt;
	
	@JsonCreator
	public static TeamGender setGender(String genderValue) throws Exception {
		for(TeamGender gender: values()) {
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
