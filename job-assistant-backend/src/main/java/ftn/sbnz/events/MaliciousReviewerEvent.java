package ftn.sbnz.events;

import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("30d")
@Getter
@Setter
public class MaliciousReviewerEvent {

	private Long jobSeekerId;
	
	private Date startDate;
	
    public MaliciousReviewerEvent() {
        super();
    }
    
    public MaliciousReviewerEvent(Long jobSeekerId) {
    	super();
    	this.jobSeekerId = jobSeekerId;
    	this.startDate = new Date();   	
    }
}
