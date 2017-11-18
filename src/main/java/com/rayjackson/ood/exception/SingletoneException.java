package com.rayjackson.ood.exception;

public class SingletoneException extends Exception {
    public SingletoneException() {
        super();
    }

    public SingletoneException(String s) {
        super(s);
    }

    public SingletoneException(Throwable cause) {
        super(cause);
    }

    public SingletoneException(String s, Throwable cause) {
        super(s, cause);
    }
}
