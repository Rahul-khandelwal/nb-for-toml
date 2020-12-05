package com.rahul.nbfortoml.parser;

import java.util.List;
import java.util.function.Function;

import javax.swing.event.ChangeListener;

import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

import com.rahul.nbfortoml.TomlNode;
import com.rahul.nbfortoml.grammer.TomlParser;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlEditorParser extends Parser {

    private final Function<String, TomlParser> parserProvider;

    private PreProParserResult parserResult;

    public TomlEditorParser(Function<String, TomlParser> parserProvider) {
        this.parserProvider = parserProvider;
    }

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent sme) throws ParseException {

        String text = snapshot.getText().toString();
        TomlParser tompParser = parserProvider.apply(text);

        TomlParserListener listener = new TomlParserListener();
        TomlErrorParserListener errorListener = new TomlErrorParserListener();
        tompParser.addParseListener(listener);
        tompParser.addErrorListener(errorListener);

        // let antlr generated Parser parse editor input
        tompParser.toml();

        // get currently parsed section of PrePro
        List<TomlNode> nodes = listener.getNodes();
        // retrieve syntax errors from antlr Listener
        List<TomlSyntaxError> errors = errorListener.getSyntaxErrors();
        // combine everything to PreProParserResult
        parserResult = new PreProParserResult(snapshot, nodes, errors);
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return parserResult;
    }

    @Override
    public void addChangeListener(ChangeListener cl) {
    }

    @Override
    public void removeChangeListener(ChangeListener cl) {
    }

    public static class PreProParserResult extends Parser.Result {

        private boolean valid = true;
        private final List<TomlNode> nodes;
        private final List<TomlSyntaxError> errors;

        public PreProParserResult(Snapshot snapshot, List<TomlNode> nodes, List<TomlSyntaxError> errors) {
            super(snapshot);
            this.nodes = nodes;
            this.errors = errors;
        }

        public List<TomlNode> getResources() {
            return nodes;
        }

        public List<TomlSyntaxError> getErrors() {
            return errors;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }

        public boolean isValid() {
            return valid;
        }
    }
}