package com.project.sns.repository;

import com.project.sns.controller.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findByUserName(String userName);
}
