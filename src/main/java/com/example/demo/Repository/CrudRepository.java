package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository <T,ID>extends JpaRepository <T,ID>{

}

/*   Users findByUserEmail(String userEmail);
   Users findByUserNickname(String userNickname);*/
   //JPA do not return booleans just objects // expected query generated SELECT * FROM users WHERE user_email = ?;

/*the main purpose of this interface is to access the data base
* thus it must remain as generic as possible.
* so this can be injected in the service class that implements JPA methods
* this method would be change for each database type in the future
*
*
*
* Extra logic and methods are defines in IUserService
* this interface can be modified or eliminated without affecting the connection to the database */