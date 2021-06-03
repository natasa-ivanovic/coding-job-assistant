package ftn.sbnz.events;

import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("5d")
@Getter
@Setter
public class ReviewDeclinedEvent {

	private Long jobSeekerId;
	
	private Date date;
	
    public ReviewDeclinedEvent() {
        super();
    }
    
    public ReviewDeclinedEvent(Long jobSeekerId) {
    	super();
    	this.jobSeekerId = jobSeekerId;
    	this.date = new Date();   	
    }
}
