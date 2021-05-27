package ftn.sbnz.model.enums;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public enum SkillProficiency {
	BASIC(0),
	GOOD(1),
	VERY_GOOD(2),
	EXCELLENT(3),
	EXPERT(4);
	
	private int value;
    @SuppressWarnings("rawtypes")
	private static Map map = new HashMap<>();

    private SkillProficiency(int value) {
        this.value = value;
    }
    
    static {
        for (SkillProficiency skillProf : SkillProficiency.values()) {
            map.put(skillProf.value, skillProf);
        }
    }

    public static SkillProficiency valueOf(int skillProf) {
        return (SkillProficiency) map.get(skillProf);
    }
    
	public int getValue() {
        return value;
    }
}
