package br.com.mateus.todolist.exception;

public class EmptyException extends RuntimeException {

    private String msg;

    public EmptyException (String msg) {
        super(msg);
    }
}
