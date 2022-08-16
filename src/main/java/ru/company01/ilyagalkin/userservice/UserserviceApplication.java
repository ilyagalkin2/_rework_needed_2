package ru.company01.ilyagalkin.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.company01.ilyagalkin.userservice.domain.Role;
import ru.company01.ilyagalkin.userservice.domain.User;
import ru.company01.ilyagalkin.userservice.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "User #1 fictional", "user1", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Actor of the times", "actor", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Polititian", "polit", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Journalist", "jour", "1234", new ArrayList<>()));

			userService.addRoleToUser("user1", "ROLE_USER");
			userService.addRoleToUser("user1", "ROLE_MANAGER");
			userService.addRoleToUser("actor", "ROLE_MANAGER");
			userService.addRoleToUser("polit", "ROLE_ADMIN");
			userService.addRoleToUser("jour", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jour", "ROLE_ADMIN");
			userService.addRoleToUser("jour", "ROLE_USER");
		};
	}

}

//[
//  {
//    "id": 5,
//    "name": "User #1 fictional",
//    "username": "user1",
//    "password": "1234",
//    "roles": [
//      {
//        "id": 1,
//        "name": "ROLE_USER"
//      },
//      {
//        "id": 2,
//        "name": "ROLE_MANAGER"
//      }
//    ]
//  },
//  {
//    "id": 6,
//    "name": "Actor of the times",
//    "username": "actor",
//    "password": "1234",
//    "roles": [
//      {
//        "id": 2,
//        "name": "ROLE_MANAGER"
//      }
//    ]
//  },
//  {
//    "id": 7,
//    "name": "Polititian",
//    "username": "polit",
//    "password": "1234",
//    "roles": [
//      {
//        "id": 3,
//        "name": "ROLE_ADMIN"
//      }
//    ]
//  },
//  {
//    "id": 8,
//    "name": "Journalist",
//    "username": "jour",
//    "password": "1234",
//    "roles": [
//      {
//        "id": 1,
//        "name": "ROLE_USER"
//      },
//      {
//        "id": 3,
//        "name": "ROLE_ADMIN"
//      },
//      {
//        "id": 4,
//        "name": "ROLE_SUPER_ADMIN"
//      }
//    ]
//  }
//]