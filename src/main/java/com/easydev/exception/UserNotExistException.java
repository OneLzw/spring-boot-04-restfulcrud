package com.easydev.exception;

/**
 * 自定义异常：用户不存在异常
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
