package br.com.mateus.todolist.exception;

public class NullValueException extends RuntimeException {

    private String msg;

    public NullValueException(String msg) {
        super(msg);
    }
}
