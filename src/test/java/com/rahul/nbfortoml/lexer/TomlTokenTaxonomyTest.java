package com.rahul.nbfortoml.lexer;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlTokenTaxonomyTest {

    @Test
    public void should_return_token_list() {
        List<TomlTokenId> result = TokenTaxonomy.INSTANCE.tokens(Category.TOML_KEY);
        assertThat(result.isEmpty(), is(false));
    }

}