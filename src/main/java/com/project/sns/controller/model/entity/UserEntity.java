package com.project.sns.controller.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class UserEntity {

    @Id
    Long userId;

    @Column(name = "user_name")
    String userName;

    @Column
    String password;
}
