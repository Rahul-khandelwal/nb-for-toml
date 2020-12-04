package com.rahul.nbfortoml.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rahul.nbfortoml.grammer.TomlLexer;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;


/**
 *
 * @author in-rahul.khandelwal
 */
public enum TokenTaxonomy {

    INSTANCE;

    private final List<TomlTokenId> tokens;

    private TokenTaxonomy() {
        tokens = new ArrayList<>();

        int max = TomlLexer.VOCABULARY.getMaxTokenType() + 1;
        for (int i = 1; i < max; i++) {
            TomlTokenId token = new TomlTokenId(TomlLexer.VOCABULARY.getDisplayName(i), Category.getCategory(i), i);
            tokens.add(token);
        }
    }

    public List<TomlTokenId> allTokens() {
        return tokens;
    }

    public List<TomlTokenId> tokens(Category category) {
        return tokens.stream().filter(t -> category.name().equals(t.primaryCategory())).collect(toList());
    }

    public Map<Integer, TomlTokenId> getIdTokenMap() {
        return tokens.stream().collect(toMap(TomlTokenId::ordinal, t -> t));
    }

}
