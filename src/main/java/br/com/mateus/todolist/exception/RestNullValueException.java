package br.com.mateus.todolist.exception;

public class RestNullValueException extends RuntimeException {

    private String msg;

    public RestNullValueException(String msg) {
        super(msg);
    }

    // shows only the error message and not the whole stack
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
