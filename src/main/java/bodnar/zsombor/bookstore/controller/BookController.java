package bodnar.zsombor.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import bodnar.zsombor.bookstore.model.Book;
import bodnar.zsombor.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody Book book) {
        return bookService.create(book);
    }
	
	@GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }
}
