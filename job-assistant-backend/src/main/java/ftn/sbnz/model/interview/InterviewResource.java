package ftn.sbnz.model.interview;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@DiscriminatorValue("RESOURCE")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class InterviewResource extends InterviewSuggestion {

	@Column(name = "url", unique = true, nullable = false)
	@NonNull
	private String url;

	@Column(name = "description", unique = false, nullable = false)
	@NonNull
	private String description;
}
