package bodnar.zsombor.bookstore.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {

	public Book(@NonNull BigDecimal price, @NonNull String author, @NonNull String title) {
		super(author + ": " + title, price);
	}

	@NonNull
	@NotEmpty
	@Setter(AccessLevel.NONE)
	private String author;

	@NonNull
	@NotEmpty
	@Setter(AccessLevel.NONE)
	private String title;

	public void setAuthor(String author) {
		this.author = author;
		setName(this.author + ": " + this.title);
	}

	public void setTitle(String title) {
		this.title = title;
		setName(this.author + ": " + this.title);
	}
}
