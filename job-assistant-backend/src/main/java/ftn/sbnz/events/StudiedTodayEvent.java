package ftn.sbnz.events;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("3m")
@Getter
@Setter
public class StudiedTodayEvent {
	
	private Long jobSeekerId;
	private Date date;
	private Date endDate;
	
	public StudiedTodayEvent() {}
	
	public StudiedTodayEvent(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
		LocalDateTime now = LocalDateTime.now();
    	this.date = Date.from(now.toInstant(ZoneOffset.UTC));
    	LocalDateTime end = now.plusSeconds(10);
    	this.endDate = Date.from(end.toInstant(ZoneOffset.UTC));
	}
}
