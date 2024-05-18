package br.com.rocketseat.managementjobs.exceptions;

public class JobNotFound extends RuntimeException{

    public JobNotFound(String message) {
        super(message);
    }
}
