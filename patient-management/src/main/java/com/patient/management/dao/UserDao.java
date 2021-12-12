package com.patient.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.management.beens.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
