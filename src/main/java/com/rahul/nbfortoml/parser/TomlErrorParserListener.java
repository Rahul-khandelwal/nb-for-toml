package com.rahul.nbfortoml.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlErrorParserListener extends BaseErrorListener {

    private final List<TomlSyntaxError> syntaxErrors = new ArrayList<>();

    public List<TomlSyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String message, RecognitionException e) {
        // at the moment we only care for error message and line
        syntaxErrors.add(new TomlSyntaxError(message, line));
    }
}