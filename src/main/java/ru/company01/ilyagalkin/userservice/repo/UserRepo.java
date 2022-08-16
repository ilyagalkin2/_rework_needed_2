package ru.company01.ilyagalkin.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company01.ilyagalkin.userservice.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
