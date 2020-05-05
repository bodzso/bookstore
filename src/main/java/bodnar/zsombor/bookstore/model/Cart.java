package bodnar.zsombor.bookstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = { "items" })
public class Cart {

	@Id
	private Long id;

	@OneToOne
	@MapsId
	@NonNull
	@NotNull
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<CartItem> items;
}
