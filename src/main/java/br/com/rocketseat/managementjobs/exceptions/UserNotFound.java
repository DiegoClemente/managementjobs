package br.com.rocketseat.managementjobs.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message) {
        super(message);
    }
}
