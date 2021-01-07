package cat.handballstats.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PlayerPosition {
	PT,
	EE,
	LE,
	CE,
	LD,
	ED,
	PV,
	PO;
	
	@JsonCreator
	public static PlayerPosition setPosition(String positionValue) throws Exception {
		for(PlayerPosition position: values()) {
			if(position.name().equals(positionValue)) {
				return position;
			}
		}
		if(positionValue == "") {
			return null;
		} else {
			throw new Exception("Cal proporcionar una posició de la llita");
		}
	}
}
