package com.rahul.nbfortoml.parser;

/**
 *
 * @author in-rahul.khandelwal
 */
public final class TomlSyntaxError {

    private final String message;
    private final int line;

    public TomlSyntaxError(String message, int line) {
        this.message = message;
        this.line = line;
    }

    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }
}