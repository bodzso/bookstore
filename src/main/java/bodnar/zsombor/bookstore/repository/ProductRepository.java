package bodnar.zsombor.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bodnar.zsombor.bookstore.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
