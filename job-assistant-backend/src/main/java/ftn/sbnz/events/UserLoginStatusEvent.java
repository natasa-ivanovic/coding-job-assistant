package ftn.sbnz.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Data;

@Role(Role.Type.EVENT)
@Expires("5m")
@Data
public class UserLoginStatusEvent {
	private Long userId;
	private boolean allowed;
	
	public UserLoginStatusEvent(Long id) {
		this.userId = id;
	}
}
