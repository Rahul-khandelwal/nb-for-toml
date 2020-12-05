package com.rahul.nbfortoml.format;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.editor.indent.spi.ReformatTask;

import com.rahul.nbfortoml.FileType;

/**
 *
 * @author in-rahul.khandelwal
 */
@MimeRegistration(mimeType = FileType.MIME, service = ReformatTask.Factory.class)
public class TomlReformatTaskFactory implements ReformatTask.Factory {

    @Override
    public ReformatTask createTask(Context context) {
        return new TomlReformatTask(context);
    }

}
