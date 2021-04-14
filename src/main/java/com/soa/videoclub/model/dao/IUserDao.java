package com.soa.videoclub.model.dao;

import com.soa.videoclub.model.User;
import org.springframework.data.repository.CrudRepository;


public interface IUserDao extends CrudRepository<User, Integer> {

}
