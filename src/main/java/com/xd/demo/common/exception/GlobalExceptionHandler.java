package com.xd.demo.common.exception;


import com.xd.demo.common.util.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleUnauthorizedException(Exception e) {
//        log.error("权限不足，{}", e.getMessage());
        return Result.error(e.getMessage());
    }
}
