package bodnar.zsombor.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import bodnar.zsombor.bookstore.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
