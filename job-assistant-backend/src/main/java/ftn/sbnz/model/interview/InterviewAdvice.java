package ftn.sbnz.model.interview;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@DiscriminatorValue("ADVICE")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class InterviewAdvice extends InterviewSuggestion {
	@Column(name = "advice", unique = false, nullable = false)
	@NonNull
	private String advice;
}
