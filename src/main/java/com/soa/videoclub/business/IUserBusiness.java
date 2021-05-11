package com.soa.videoclub.business;

import com.soa.videoclub.business.exception.BusinessException;
import com.soa.videoclub.business.exception.NotFoundException;
import com.soa.videoclub.model.User;


import java.util.List;

public interface IUserBusiness {

	public List<User> findAll() throws BusinessException;

    public void save(User user);

    public User findOne(int id);

    public void delete(int id);
}
