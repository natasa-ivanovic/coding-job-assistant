package ftn.sbnz.events;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("90d")
@Getter
@Setter
public class MaliciousReviewerEvent {

	private Long jobSeekerId;
	
	private Date startDate;

	private Date endDate;
	
	private boolean active;
	
    public MaliciousReviewerEvent() {
        super();
    }
    
    public MaliciousReviewerEvent(Long jobSeekerId) {
    	super();
    	this.jobSeekerId = jobSeekerId;
    	LocalDateTime now = LocalDateTime.now();
    	this.startDate = Date.from(now.toInstant(ZoneOffset.ofHours(2)).plusSeconds(1));
    	LocalDateTime end = now.plusMinutes(1);
    	this.endDate = Date.from(end.toInstant(ZoneOffset.ofHours(2)));
    	this.active = true;
    }
}
