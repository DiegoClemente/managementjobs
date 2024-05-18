package br.com.rocketseat.managementjobs.exceptions;

public class CompanyNotFound extends RuntimeException{

    public CompanyNotFound(String message) {
        super(message);
    }
}
