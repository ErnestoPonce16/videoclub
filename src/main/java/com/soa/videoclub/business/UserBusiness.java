package com.soa.videoclub.business;

import com.soa.videoclub.model.User;
import com.soa.videoclub.model.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserBusiness implements IUserBusiness{

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(int id) {
        return userDao.findById(id).get();
    }

    @Override
    @Transactional
    public void save(User user){
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.deleteById(id);
    }

}
