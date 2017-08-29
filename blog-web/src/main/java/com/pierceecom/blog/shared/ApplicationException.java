package com.pierceecom.blog.shared;

public class ApplicationException extends RuntimeException {

    public enum TYPE {
        NOT_FOUND, NULL_KEY_NOT_ALLOWED
    }

    private TYPE type;

    public ApplicationException(TYPE type) {
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }
}
