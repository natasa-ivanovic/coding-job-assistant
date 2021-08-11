package ftn.sbnz.dto.user;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	@NonNull
	@NotBlank(message = "Username is required!")
	private String username;
	
	@NonNull
	@NotBlank(message = "Name is required!")
	private String name;
	
	@NonNull
	@NotBlank(message = "Surname is required!")
	private String surname;
	
	@NonNull
	@NotBlank(message = "Password is required!")
	private String password;

}
