package ftn.sbnz.events;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("120d")
@Getter
@Setter
public class DisabledUserEvent {
	private Long jobSeekerId;
	
	private Date startDate;
	
    public DisabledUserEvent() {
        super();
    }
    
    public DisabledUserEvent(Long jobSeekerId) {
    	super();
    	this.jobSeekerId = jobSeekerId;
    	this.startDate = Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(2))); 	
    }
}
