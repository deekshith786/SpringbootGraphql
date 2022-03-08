package com.graphql.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.demo.Entity.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}
