package bodnar.zsombor.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bodnar.zsombor.bookstore.model.Book;
import bodnar.zsombor.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Long create(Book book)
	{
		return bookRepository.save(book).getId();
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}
}
