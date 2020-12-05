package com.rahul.nbfortoml.parser;

import java.util.function.Function;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import com.rahul.nbfortoml.grammer.TomlLexer;
import com.rahul.nbfortoml.grammer.TomlParser;

/**
 *
 * @author in-rahul.khandelwal
 */
public enum TomlParserProvider implements Function<String, TomlParser> {

    INSTANCE;

    @Override
    public TomlParser apply(String text) {
        CharStream input = CharStreams.fromString(text);
        Lexer lexer = new TomlLexer(input);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        return new TomlParser(tokenStream);
    }
}