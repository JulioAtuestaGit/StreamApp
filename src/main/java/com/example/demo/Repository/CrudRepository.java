package com.example.demo.Repository;
import com.example.demo.model.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository <Users,Integer>{
    SecurityProperties.User findByUserEmail(String userEmail); //JPA do not return booleans just objects

}
/*the main purpose of this interface is to access the data base
* thus it must remain as generic as possible.
* so this can be injected in the service class that implements JPA methods
* this method would be change for each database type in the future
*
*
*
* Extra logic and methods are defines in IUserService
* this interface can be modified or eliminated without affecting the connection to the database */