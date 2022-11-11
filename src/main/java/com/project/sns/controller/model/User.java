package com.project.sns.controller.model;

import com.project.sns.controller.model.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private UserRole userRole;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;



    public static  User fromEntity(UserEntity entity){
        return new User(
                entity.getUserName(),
                entity.getPassword(),
                entity.getRole(),
                entity.getRegisterAt(),
                entity.getUpdatedAt(),
                entity.getDeletedAt()
        );
    }
}
