package bodnar.zsombor.bookstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	@NotEmpty
	private String name;

	@NonNull
	@NotNull
	private BigDecimal price;
}
