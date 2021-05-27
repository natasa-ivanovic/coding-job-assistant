package ftn.sbnz.model.enums;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public enum SeniorityLevel {
	NONE(0),
	JUNIOR(1),
	MEDIOR(2),
	SENIOR(3);
	
	private int value;
    @SuppressWarnings("rawtypes")
	private static Map map = new HashMap<>();

    private SeniorityLevel(int value) {
        this.value = value;
    }
    
    static {
        for (SeniorityLevel level : SeniorityLevel.values()) {
            map.put(level.value, level);
        }
    }

    public static SeniorityLevel valueOf(int level) {
        return (SeniorityLevel) map.get(level);
    }
    
	public int getValue() {
        return value;
    }
}
