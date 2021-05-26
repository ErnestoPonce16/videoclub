package com.soa.videoclub.model.dao;

import com.soa.videoclub.model.User;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.solr.repository.SolrCrudRepository;





public interface IUserDao extends SolrCrudRepository <User, Integer> {
}


