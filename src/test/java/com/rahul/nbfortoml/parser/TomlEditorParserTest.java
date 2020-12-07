package com.rahul.nbfortoml.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 *
 * @author in-rahul.khandelwal
 */
@ExtendWith(MockitoExtension.class)
public class TomlEditorParserTest {

    private static final String TEXT = "# This is a TOML document\n" +
                                        "\n" +
                                        "title = \"TOML Example\"\n" +
                                        "\n" +
                                        "[owner]\n" +
                                        "name = \"Open Source\"\n" +
                                        "dob = 1979-05-27T07:32:00-08:00";

    @Mock
    private Snapshot snapshot;

    @Mock
    private Task task;

    @Mock
    private SourceModificationEvent event;

    private TomlEditorParser classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new TomlEditorParser(TomlParserProvider.INSTANCE);
        given(snapshot.getText()).willReturn(TEXT);
    }

    @Test
    public void parser_should_produce_some_results() throws Exception {
        classUnderTest.parse(snapshot, task, event);
        Parser.Result result = classUnderTest.getResult(task);
        assertThat(result instanceof TomlEditorParser.TomlParserResult, is(true));
    }

}
