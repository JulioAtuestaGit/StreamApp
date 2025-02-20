package com.example.demo.Repository;
import com.example.demo.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface ICrudUserRepo extends CrudRepository <Users,Integer>{
    Users findByUserEmail(String userEmail);
    Users findByUserNickname(String userNickname);
}
