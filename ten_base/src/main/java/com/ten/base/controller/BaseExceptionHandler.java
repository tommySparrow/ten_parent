package com.ten.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 同一处理异常类
 * @author jerry
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public Result exception(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}