package com.project.sns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, String.format("User name is deplicated"))
    ;

    private HttpStatus status;
    private String message;
}
