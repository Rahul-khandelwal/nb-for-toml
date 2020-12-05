package com.rahul.nbfortoml.parser;

import java.util.Collection;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.SchedulerTask;
import org.netbeans.modules.parsing.spi.TaskFactory;

import com.rahul.nbfortoml.FileType;

import static java.util.Collections.singletonList;

/**
 *
 * @author in-rahul.khandelwal
 */
@MimeRegistration(mimeType = FileType.MIME, service = TaskFactory.class)
public class TomlSyntaxErrorHighlightingTaskFactory extends TaskFactory{

    @Override
    public Collection<? extends SchedulerTask> create(Snapshot snpsht) {
        return singletonList(new TomlSyntaxErrorHighlightingTask());
    }

}
