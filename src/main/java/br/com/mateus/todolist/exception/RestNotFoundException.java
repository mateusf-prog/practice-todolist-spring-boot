package br.com.mateus.todolist.exception;

public class RestNotFoundException extends RuntimeException {

    private String msg;

    public RestNotFoundException(String msg) {
        super(msg);
    }

    // shows only the error message and not the whole stack
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
