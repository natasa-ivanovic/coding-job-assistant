package ftn.sbnz.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import lombok.Getter;
import lombok.Setter;

@Role(Role.Type.EVENT)
@Expires("120d")
@Getter
@Setter
public class InvalidLoginEvent {
	private Long jobSeekerId;

	public InvalidLoginEvent() {
		super();
	}

	public InvalidLoginEvent(Long jobSeekerId) {
		super();
		this.jobSeekerId = jobSeekerId;
	}
}
