package ftn.sbnz.events;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Data;

@Role(Role.Type.EVENT)
@Expires("5m")
@Data
public class UserAccountStatusEvent {
	private Long userId;
	private Date eventTime;
	private boolean allowed;
	private boolean banned;
	
	public UserAccountStatusEvent(Long id) {
		this.userId = id;
    	LocalDateTime now = LocalDateTime.now();
    	this.eventTime = Date.from(now.toInstant(ZoneOffset.UTC));
	}
}
