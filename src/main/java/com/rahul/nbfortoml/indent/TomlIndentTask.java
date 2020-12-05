package com.rahul.nbfortoml.indent;

import javax.swing.text.BadLocationException;

import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.IndentTask;
import org.openide.awt.StatusDisplayer;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlIndentTask implements IndentTask {

    private Context context;

    TomlIndentTask(Context context) {
        this.context = context;
    }

    @Override
    public void reindent() throws BadLocationException {
        StatusDisplayer.getDefault().setStatusText("We will indent this now...");
    }

    @Override
    public ExtraLock indentLock() {
        return null;
    }

}
