package bodnar.zsombor.bookstore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = { "items" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

	@Transient
	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	private BigDecimal total;

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);

		if (items == null)
			return total;

		for (var item : items) {
			total.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}

		return total;
	}
}
