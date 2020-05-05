package bodnar.zsombor.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import bodnar.zsombor.bookstore.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
