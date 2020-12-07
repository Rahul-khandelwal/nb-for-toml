package com.rahul.nbfortoml.parser;


import java.util.List;

import javax.swing.text.Document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Source;

import com.rahul.nbfortoml.TomlNode;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


/**
 *
 * @author in-rahul.khandelwal
 */
@ExtendWith(MockitoExtension.class)
public class TomlSyntaxErrorHighlightingTaskTest {

    @Mock
    private Snapshot snapshot;

    @Mock
    private Source source;

    @Mock
    private Document document;

    private TomlSyntaxErrorHighlightingTask classUnderTest;

    private TomlEditorParser.TomlParserResult tomlResult;

    @BeforeEach
    void setup() {
        List<TomlNode> res = singletonList(new TomlNode("foo", 0, 0));
        List<TomlSyntaxError> errs = singletonList(new TomlSyntaxError("bar", 0));
        tomlResult = new TomlEditorParser.TomlParserResult(snapshot, res, errs);
        classUnderTest = Mockito.spy(new TomlSyntaxErrorHighlightingTask());
    }

    @Test
    public void should_set_errors() {
        given(snapshot.getSource()).willReturn(source);
        given(source.getDocument(false)).willReturn(document);

        classUnderTest.run(tomlResult, null);

        verify(classUnderTest).setErrors(eq(document), any(List.class));
    }

    @Test
    public void should_not_set_errors() {
        tomlResult.invalidate();
        classUnderTest.run(tomlResult, null);

        verify(classUnderTest, never()).setErrors(eq(document), any(List.class));
    }
    
}
