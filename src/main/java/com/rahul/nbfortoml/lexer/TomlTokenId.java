package com.rahul.nbfortoml.lexer;

import org.netbeans.api.lexer.TokenId;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    TomlTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
