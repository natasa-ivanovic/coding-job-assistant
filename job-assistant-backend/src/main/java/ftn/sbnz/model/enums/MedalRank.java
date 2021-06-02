package ftn.sbnz.model.enums;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public enum MedalRank {
	NONE(0),
	BRONZE(1),
	SILVER(2),
	GOLD(3);
	
	private int value;
    @SuppressWarnings("rawtypes")
	private static Map map = new HashMap<>();

    private MedalRank(int value) {
        this.value = value;
    }
    
    static {
        for (MedalRank medalRank : MedalRank.values()) {
            map.put(medalRank.value, medalRank);
        }
    }

    public static SkillProficiency valueOf(int skillProf) {
        return (SkillProficiency) map.get(skillProf);
    }
    
    public int getValue() {
        return value;
    }
}
