package bodnar.zsombor.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import bodnar.zsombor.bookstore.model.Book;
import bodnar.zsombor.bookstore.model.Cart;
import bodnar.zsombor.bookstore.model.User;
import bodnar.zsombor.bookstore.repository.CartItemRepository;
import bodnar.zsombor.bookstore.repository.CartRepository;
import bodnar.zsombor.bookstore.repository.UserRepository;
import bodnar.zsombor.bookstore.service.BookService;
import bodnar.zsombor.bookstore.service.CartService;
import bodnar.zsombor.bookstore.service.UserService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	CartService cartService;

	@Autowired
	BookService bookService;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CartItemRepository cartItemRepository;

	static ArrayList<Long> userIds = new ArrayList<>();

	static ArrayList<Long> cartIds = new ArrayList<>();

	static ArrayList<Long> bookIds = new ArrayList<>();

	@Test
	@Order(1)
	void contextLoads() {
	}

	@Test
	@Order(2)
	void createEntities() {
		userIds.add(userService.createUser(new User("Julio", "Gault")));
		userIds.add(userService.createUser(new User("Freddie", "Goggin")));
		userIds.add(userService.createUser(new User("Valery", "Scalia")));

		cartIds.add(cartService.create(userIds.get(0)));
		cartIds.add(cartService.create(userIds.get(1)));
		cartIds.add(cartService.create(userIds.get(2)));

		bookIds.add(bookService.create(new Book(new BigDecimal(1500), "Giricz Máté", "Giricz Máté festőművész")));
		bookIds.add(bookService.create(new Book(new BigDecimal(500), "Berde Mária", "Versek")));
		bookIds.add(bookService.create(new Book(new BigDecimal(3000), "Petelei István", "Felhők")));
	}

	@Test
	@Order(3)
	void addProducts() {
		// User 1
		cartService.addProduct(bookIds.get(0), cartIds.get(0), 1);
		cartService.addProduct(bookIds.get(0), cartIds.get(0), 3);
		cartService.updateTotal(cartIds.get(0));

		// User 2
		cartService.addProduct(bookIds.get(0), cartIds.get(1), 5);
		cartService.updateTotal(cartIds.get(1));

		// User 3
		cartService.addProduct(bookIds.get(0), cartIds.get(2), 1);
		cartService.addProduct(bookIds.get(1), cartIds.get(2), 1);
		cartService.addProduct(bookIds.get(2), cartIds.get(2), 1);
		cartService.updateTotal(cartIds.get(2));
	}

	@Test
	@Order(4)
	@Transactional
	void testCart1() {
		Cart cart1 = cartRepository.getOne(cartIds.get(0));

		assertThat(cart1.getItems().size()).isEqualTo(1);
		assertThat(cart1.getItems().get(0).getQuantity()).isEqualTo(4);
	}

	@Test
	@Order(4)
	@Transactional
	void testCart1Sum() {
		Cart cart1 = cartRepository.getOne(cartIds.get(0));

		org.hamcrest.MatcherAssert.assertThat(cart1.getTotal(), Matchers.comparesEqualTo(new BigDecimal(6000)));
	}

	@Test
	@Order(5)
	@Transactional
	void testCart2() {
		Cart cart2 = cartRepository.getOne(cartIds.get(1));

		assertThat(cart2.getItems().get(0).getQuantity()).isEqualTo(5);
	}

	@Test
	@Order(6)
	@Transactional
	void testCart3() {
		Cart cart3 = cartRepository.getOne(cartIds.get(2));

		assertThat(cart3.getItems().size()).isEqualTo(3);
	}

	@Test
	@Order(7)
	@Transactional
	void checkoutCarts() {
		Cart cart1 = cartRepository.getOne(cartIds.get(0));
		Cart cart2 = cartRepository.getOne(cartIds.get(1));
		Cart cart3 = cartRepository.getOne(cartIds.get(2));

		assertThat(cart1.getItems()).isNotEmpty();
		cartService.checkoutCart(cartIds.get(0));

		assertThat(cart2.getItems()).isNotEmpty();
		cartService.checkoutCart(cartIds.get(1));

		assertThat(cart3.getItems()).isNotEmpty();
		cartService.checkoutCart(cartIds.get(2));
	}
}
