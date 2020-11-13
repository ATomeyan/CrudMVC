package com.bdg.crudmvc.repository;

import com.bdg.crudmvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}