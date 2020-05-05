package bodnar.zsombor.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	@NotEmpty
	private String firstName;

	@NonNull
	@NotEmpty
	private String lastName;

	@OneToOne(mappedBy = "user")
	private Cart cart;
}
