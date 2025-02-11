package com.example.demo.Repository;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository <Users,Integer>{

}
