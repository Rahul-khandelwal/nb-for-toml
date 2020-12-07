package com.rahul.nbfortoml.lexer;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlLanguageHierarchyTest {

    private TomlLanguageHierarchy classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new TomlLanguageHierarchy();
    }

    @Test
    public void should_return_tokens() {
        Collection<TomlTokenId> result = classUnderTest.createTokenIds();
        assertThat(result.isEmpty(), is(false));
    }
}
