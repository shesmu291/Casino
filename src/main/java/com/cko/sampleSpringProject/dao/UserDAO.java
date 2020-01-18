package com.cko.sampleSpringProject.dao;

import com.cko.sampleSpringProject.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Email;

public interface UserDAO extends CrudRepository<User,Long> {

    User findByEmail(String email);




    User findUserById(long id);


}
