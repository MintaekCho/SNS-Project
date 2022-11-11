package com.project.sns.service;

import com.project.sns.controller.model.User;
import com.project.sns.controller.model.entity.UserEntity;
import com.project.sns.exception.ErrorCode;
import com.project.sns.exception.SnsApplicationException;
import com.project.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    //TODO : implement
    public User join(String username, String password) {
        //회원가입하려는 userName으로 회원가입된 user가 있는
         userEntityRepository.findByUserName(username).ifPresent(it -> {
             throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("%s is duplicated", username));
         });

        // 회원가입 진행 = user등록
        UserEntity saveUser = userEntityRepository.save(new UserEntity());
        return User.fromEntity(saveUser);

    }

    // TODO : implement
    public String login(String userName, String password) {
        //회원가입 체크 여부
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());


        //비밀번호 체크
        if(userEntity.getPassword().equals(password)){
            throw new SnsApplicationException();
        }



        //토큰 생성

        return "";
    }
}