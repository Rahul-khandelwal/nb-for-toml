package com.rahul.nbfortoml.format;

import javax.swing.text.BadLocationException;

import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ExtraLock;
import org.netbeans.modules.editor.indent.spi.ReformatTask;
import org.openide.awt.StatusDisplayer;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlReformatTask implements ReformatTask {
    private Context context;

    public TomlReformatTask(Context context) {
        this.context = context;
    }

    @Override
    public void reformat() throws BadLocationException {
        StatusDisplayer.getDefault().setStatusText("We will format this now...");
    }

    @Override
    public ExtraLock reformatLock() {
        return null;
    }
}
