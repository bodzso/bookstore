package bodnar.zsombor.bookstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CartItem {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Cart cart;

	@ManyToOne
	@NonNull
	@NotNull
	private Product product;

	@NonNull
	@NotNull
	private Integer quantity;
}
