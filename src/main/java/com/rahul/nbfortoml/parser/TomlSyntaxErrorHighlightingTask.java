package com.rahul.nbfortoml.parser;

import java.util.List;

import javax.swing.text.Document;

import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;

import com.rahul.nbfortoml.TomlLookupContext;

import static java.util.stream.Collectors.toList;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlSyntaxErrorHighlightingTask extends ParserResultTask {

    @Override
    public void run(Parser.Result result, SchedulerEvent se) {
        TomlEditorParser.TomlParserResult tomlResult = (TomlEditorParser.TomlParserResult) result;

        if (tomlResult.isValid()) {

            TomlLookupContext.INSTANCE.add(tomlResult.getResources());

            Document document = result.getSnapshot().getSource().getDocument(false);
            List<TomlSyntaxError> errors = tomlResult.getErrors();
            List<ErrorDescription> descriptions = errors.stream().map(e
                    -> ErrorDescriptionFactory.createErrorDescription(
                            Severity.ERROR,
                            e.getMessage(),
                            document,
                            e.getLine())).collect(toList());
            setErrors(document, descriptions);
        }
    }

    void setErrors(Document document, List<ErrorDescription> descriptions) {
        HintsController.setErrors(document, "toml", descriptions);
    }

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public Class<? extends Scheduler> getSchedulerClass() {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    @Override
    public void cancel() {
    }
}