package br.com.rocketseat.managementjobs.exceptions;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message) {
        super(message);
    }
}
