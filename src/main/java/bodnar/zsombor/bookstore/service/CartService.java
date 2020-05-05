package bodnar.zsombor.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bodnar.zsombor.bookstore.model.Cart;
import bodnar.zsombor.bookstore.model.User;
import bodnar.zsombor.bookstore.repository.CartRepository;
import bodnar.zsombor.bookstore.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public Long create(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
		Cart savedCart = cartRepository.save(new Cart(user));
		
		user.setCart(savedCart);
		userRepository.save(user);
		
		return savedCart.getId();
	}

	public List<Cart> findAll() {
		return (List<Cart>) cartRepository.findAll();
	}
}
