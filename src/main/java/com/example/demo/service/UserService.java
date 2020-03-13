package com.example.demo.service;



import com.example.demo.game.User;
import com.example.demo.db.entity.UserTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

   UserTable save(User user);


   Optional<UserTable> getById(UUID id);

    void delete(UUID id);

    List<UserTable> getAll();




}
