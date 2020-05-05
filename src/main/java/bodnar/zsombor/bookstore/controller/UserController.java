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

import bodnar.zsombor.bookstore.model.User;
import bodnar.zsombor.bookstore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody User user) {
		return userService.createUser(user);
	}
}
