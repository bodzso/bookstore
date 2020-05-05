package bodnar.zsombor.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bodnar.zsombor.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
