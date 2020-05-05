package bodnar.zsombor.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartItem {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@NonNull
	@NotNull
	private Cart cart;

	@ManyToOne
	@NonNull
	@NotNull
	private Product product;

	@NonNull
	@NotNull
	private Integer quantity;
}
