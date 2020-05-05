package bodnar.zsombor.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bodnar.zsombor.bookstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
