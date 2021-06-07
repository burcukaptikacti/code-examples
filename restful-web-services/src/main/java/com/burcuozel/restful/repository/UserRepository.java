package com.burcuozel.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burcuozel.restful.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
