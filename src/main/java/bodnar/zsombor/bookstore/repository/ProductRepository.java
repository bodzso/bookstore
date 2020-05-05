package bodnar.zsombor.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import bodnar.zsombor.bookstore.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
