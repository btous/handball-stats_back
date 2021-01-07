package cat.handballstats.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GamePhase {
    
	defence,
	counterattack,
	attack,
	returndefense;
	
	@JsonCreator
	public static GamePhase setPhase(String phaseValue) throws Exception {
		for(GamePhase phase: values()) {
			if(phase.name().equals(phaseValue)) {
				return phase;
			}
		}
		if(phaseValue == "") {
			return null;
		} else {
			throw new Exception("Cal proporcionar un gènere de la llita");
		}
	}
}
