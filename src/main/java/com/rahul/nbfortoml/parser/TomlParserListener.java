package com.rahul.nbfortoml.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.rahul.nbfortoml.TomlNode;
import com.rahul.nbfortoml.grammer.TomlParserBaseListener;

/**
 *
 * @author in-rahul.khandelwal
 */
public final class TomlParserListener extends TomlParserBaseListener {

    private final List<TomlNode> nodes = new ArrayList<>();

    public List<TomlNode> getNodes() {
        return nodes;
    }

    private void addNode(TerminalNode node, int type, int offset) {
        if (node != null && !(node instanceof ErrorNode)) {
            addNode(node.getText(), type, offset);
        }
    }

    private void addNode(String text, int type, int offset) {
        nodes.add(new TomlNode(text, type, offset));
    }

    private int getStart(ParserRuleContext ctx) {
        return ctx.getStart().getStartIndex();
    }
}
