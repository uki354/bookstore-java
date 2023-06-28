package com.bookstore.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.bookstore.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    boolean existsByEmail(String email);
    Optional<UserModel> findUserModelByEmail(String email);
    @Query(value = "select u from UserModel u inner join fetch u.roles where u.email = :email ")
    Optional<UserModel>findUserByEmailAndFetchRoles(String email);
   

}
