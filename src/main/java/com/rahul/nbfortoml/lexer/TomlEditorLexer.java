package com.rahul.nbfortoml.lexer;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import org.antlr.v4.runtime.CharStream;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;

import com.rahul.nbfortoml.grammer.TomlLexer;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlEditorLexer implements Lexer<TomlTokenId> {

    private final LexerRestartInfo<TomlTokenId> info;
    private final Map<Integer, TomlTokenId> idToToken;

    private final Function<TomlTokenId, Token<TomlTokenId>> tokenFactory;
    private final Supplier<org.antlr.v4.runtime.Token> tokenSupplier;

    public TomlEditorLexer(LexerRestartInfo<TomlTokenId> info, Map<Integer, TomlTokenId> idToToken) {
        this(info, idToToken, new TokenSupplier(info.input()));
    }

    TomlEditorLexer(LexerRestartInfo<TomlTokenId> info, Map<Integer, TomlTokenId> idToToken,
            Supplier<org.antlr.v4.runtime.Token> tokenSupplier) {
        this.info = info;
        this.idToToken = idToToken;
        this.tokenSupplier = tokenSupplier;
        this.tokenFactory = id -> info.tokenFactory().createToken(id);
    }

    @Override
    public Token<TomlTokenId> nextToken() {
        Token<TomlTokenId> createdToken = null;

        org.antlr.v4.runtime.Token token = tokenSupplier.get();

        int type = token.getType();
        if (type != -1) {
            createdToken = createToken(type);
        } else if (info.input().readLength() > 0) {
            createdToken = createToken(TomlLexer.WS);
        }

        return createdToken;
    }

    private Token<TomlTokenId> createToken(int type) {
        Function<Integer, TomlTokenId> mapping = idToToken::get;
        return mapping.andThen(tokenFactory).apply(type);
    }

    @Override
    public Object state() {
        return null;
    }

    @Override
    public void release() {
        //not implemented
    }

    private static class TokenSupplier implements Supplier<org.antlr.v4.runtime.Token> {

        private final TomlLexer lexer;
        // tunnel editor Input to antlr
        TokenSupplier(LexerInput input) {
            CharStream stream = new TomlCharStream(input);
            lexer = new TomlLexer(stream);
        }

        @Override
        public org.antlr.v4.runtime.Token get() {
            return lexer.nextToken();
        }
    }

}