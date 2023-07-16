package com.app.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
