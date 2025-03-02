package com.example.demo.services.Interfaces;

import com.example.demo.model.Users;

public interface IUserService extends  IDataService<Users>  {
    public Users findByUserEmail(String userEmail);
    public Users findByUserNickname(String userNickname);
}
