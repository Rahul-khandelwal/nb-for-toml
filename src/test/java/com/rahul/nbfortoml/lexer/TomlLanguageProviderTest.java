package com.rahul.nbfortoml.lexer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.netbeans.api.lexer.Language;

import com.rahul.nbfortoml.FileType;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlLanguageProviderTest {

    private TomlLanguageProvider classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new TomlLanguageProvider();
    }

    @Test
    public void should_return_null_when_mime_is_null() {
        Language result = classUnderTest.findLanguage(null);
        assertThat(result, nullValue());
    }

    @Test
    public void should_return_language_for_mime() {
        String mime = FileType.MIME;
        Language result = classUnderTest.findLanguage(mime);
        assertThat(result.mimeType(), equalTo(mime));
    }

}
