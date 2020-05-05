package bodnar.zsombor.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import bodnar.zsombor.bookstore.model.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

}
