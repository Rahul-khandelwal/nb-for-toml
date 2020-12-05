package com.rahul.nbfortoml.indent;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.IndentTask;

import com.rahul.nbfortoml.FileType;

/**
 *
 * @author in-rahul.khandelwal
 */
@MimeRegistration(mimeType = FileType.MIME, service = IndentTask.Factory.class)
public class TomlIndentTaskFactory implements IndentTask.Factory {

    @Override
    public IndentTask createTask(Context context) {
        return new TomlIndentTask(context);
    }

}
