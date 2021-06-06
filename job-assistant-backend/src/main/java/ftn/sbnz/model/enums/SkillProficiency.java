package ftn.sbnz.model.enums;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public enum SkillProficiency {
	NONE(0),
	BASIC(1),
	GOOD(2),
	VERY_GOOD(3),
	EXCELLENT(4),
	EXPERT(5);
	
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
    
    public int skillDifference(SkillProficiency skillProf) {
    	if (this.getValue() == skillProf.getValue())
    		return 1;
    	if (this.getValue() > skillProf.getValue())
    		return this.getValue() - skillProf.getValue() + 1;
    	
    	return this.getValue() - skillProf.getValue() - 1;
    }
    
	public int getValue() {
        return value;
    }
}
