package com.project.sns.controller.model.entity;

import com.project.sns.controller.model.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATED \"user\" SET deleted at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    //디버깅 때 데이터가 언제들어오고, 수정되고, 삭제되었는지 확인하기 위해 -- 데이터 관리에 용이하다.
    @Column(name = "register_at")
    private Timestamp registerAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt(){
        this.registerAt = Timestamp.from(Instant.now());
    }

    @PrePersist
    void updatedAt(){
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static UserEntity of(String userName, String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
    }
}
