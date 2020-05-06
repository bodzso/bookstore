package bodnar.zsombor.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bodnar.zsombor.bookstore.model.User;
import bodnar.zsombor.bookstore.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public Long createUser(User user) {
		return userRepository.save(user).getId();
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
