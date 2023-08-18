package br.com.snn.apitest.services.exception;

public class ObjectNotFoundExeption extends RuntimeException{
    public ObjectNotFoundExeption(String message) {
        super(message);
    }
}
