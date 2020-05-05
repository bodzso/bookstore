package bodnar.zsombor.bookstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = { "items" })
public class Cart {

	@Id
	private Long id;

	@OneToOne
	@MapsId
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<CartItem> items;
}
