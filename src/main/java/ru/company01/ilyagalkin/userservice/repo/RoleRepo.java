package ru.company01.ilyagalkin.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.company01.ilyagalkin.userservice.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
