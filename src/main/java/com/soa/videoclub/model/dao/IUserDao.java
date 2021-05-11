package com.soa.videoclub.model.dao;

import com.soa.videoclub.model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserDao extends JpaRepository<User, Integer> {

}
