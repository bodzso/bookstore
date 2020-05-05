package bodnar.zsombor.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bodnar.zsombor.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
