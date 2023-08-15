package br.com.mateus.todolist.exception;

public class NotFoundException extends RuntimeException {

    private String msg;

    public NotFoundException(String msg) {
        super(msg);
    }

    // shows only the error message and not the whole stack
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
