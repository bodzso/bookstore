package bodnar.zsombor.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import bodnar.zsombor.bookstore.model.Cart;
import bodnar.zsombor.bookstore.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long createCart(@RequestBody Long userId) {
		return cartService.create(userId);
	}

	@GetMapping
	public List<Cart> findAll() {
		return cartService.findAll();
	}

	@PostMapping(value = "/add-product/{cartId}/{productId}/{quantity}")
	@ResponseStatus(HttpStatus.OK)
	public void addProduct(@PathVariable("cartId") Long productId, @PathVariable("productId") Long cartId,
			@PathVariable("quantity") Integer quantity) {
		cartService.addProduct(productId, cartId, quantity);
	}
}
