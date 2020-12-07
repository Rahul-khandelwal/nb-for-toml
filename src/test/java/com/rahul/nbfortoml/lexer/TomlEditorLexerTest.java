package com.rahul.nbfortoml.lexer;

import java.util.Map;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netbeans.api.lexer.Token;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.spi.lexer.TokenFactory;

import static java.util.Collections.singletonMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 *
 * @author in-rahul.khandelwal
 */
@ExtendWith(MockitoExtension.class)
public class TomlEditorLexerTest {

    @Mock
    private LexerRestartInfo<TomlTokenId> info;

    @Mock
    private TokenFactory tokenFactory;

    @Mock
    private Supplier<org.antlr.v4.runtime.Token> tokenSupplier;

    @Mock
    private org.antlr.v4.runtime.Token antlrToken;

    @Mock
    private Token<TomlTokenId> token;

    private TomlEditorLexer classUnterTest;

    @BeforeEach
    void setUp() {
        given(info.tokenFactory()).willReturn(tokenFactory);
        given(tokenSupplier.get()).willReturn(antlrToken);

        Map<Integer, TomlTokenId> map = singletonMap(0, new TomlTokenId("foo", Category.TOML_KEY.name(), 10));
        classUnterTest = new TomlEditorLexer(info, map, tokenSupplier);
    }

    @Test
    @DisplayName("The lexer should return a token.")
    public void testNextToken() {
        given(tokenFactory.createToken(any(TomlTokenId.class))).willReturn(token);
        Token<TomlTokenId> result = classUnterTest.nextToken();
        assertThat(result, equalTo(token));
    }
}
