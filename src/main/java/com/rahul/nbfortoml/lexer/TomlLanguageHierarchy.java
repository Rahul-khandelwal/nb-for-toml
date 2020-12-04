package com.rahul.nbfortoml.lexer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

import com.rahul.nbfortoml.FileType;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlLanguageHierarchy extends LanguageHierarchy<TomlTokenId> {

    private static List<TomlTokenId> tokens;
    private static Map<Integer, TomlTokenId> idToToken;

    private static void init() {
        tokens = TokenTaxonomy.INSTANCE.allTokens();
        idToToken = TokenTaxonomy.INSTANCE.getIdTokenMap();
    }

    static synchronized TomlTokenId getToken(int id) {
        if (idToToken == null) {
            init();
        }
        return idToToken.get(id);
    }

    @Override
    protected synchronized Collection<TomlTokenId> createTokenIds() {
        if (tokens == null) {
            init();
        }
        return tokens;
    }

    @Override
    protected synchronized Lexer<TomlTokenId> createLexer(LexerRestartInfo<TomlTokenId> info) {
        return new TomlEditorLexer(info, idToToken);
    }

    @Override
    protected String mimeType() {
        return FileType.MIME;
    }
}
