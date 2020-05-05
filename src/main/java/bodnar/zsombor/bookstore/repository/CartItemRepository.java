package bodnar.zsombor.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bodnar.zsombor.bookstore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
