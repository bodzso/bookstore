package bodnar.zsombor.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import bodnar.zsombor.bookstore.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
