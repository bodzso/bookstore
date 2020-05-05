package bodnar.zsombor.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bodnar.zsombor.bookstore.model.Cart;
import bodnar.zsombor.bookstore.model.CartItem;
import bodnar.zsombor.bookstore.model.Product;
import bodnar.zsombor.bookstore.model.User;
import bodnar.zsombor.bookstore.repository.CartItemRepository;
import bodnar.zsombor.bookstore.repository.CartRepository;
import bodnar.zsombor.bookstore.repository.ProductRepository;
import bodnar.zsombor.bookstore.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Transactional
	public Long create(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		Cart savedCart = cartRepository.save(new Cart(user));
		
		user.setCart(savedCart);
		userRepository.save(user);
		
		return savedCart.getId();
	}

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}
	
	@Transactional
	public void addProduct(Long productId, Long cartId, Integer quantity) {
		Product product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
		Cart cart = cartRepository.findById(cartId).orElseThrow(IllegalArgumentException::new);
		
		CartItem cartItem = cartItemRepository.findFirstByCart_IdAndProduct_Id(cartId, productId);
		
		if(cartItem == null)
			cartItem = cartItemRepository.save(new CartItem(cart, product, quantity));
		else {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
			cartItemRepository.save(cartItem);
		}
	}
	
	@Transactional
	public void removeProduct(Long productId, Long cartId, Integer quantity) {
		productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
		cartRepository.findById(cartId).orElseThrow(IllegalArgumentException::new);

		CartItem cartItem = cartItemRepository.findFirstByCart_IdAndProduct_Id(cartId, productId);

		if (cartItem == null || cartItem.getQuantity() < quantity)
			throw new IllegalArgumentException();
		else if (cartItem.getQuantity() == quantity) {
			cartItemRepository.deleteById(cartItem.getId());
		} else {
			cartItem.setQuantity(cartItem.getQuantity() - quantity);
			cartItemRepository.save(cartItem);
		}
	}
}
