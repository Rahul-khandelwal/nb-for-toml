package com.rahul.nbfortoml.parser;

import java.util.Collection;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.ParserFactory;

import com.rahul.nbfortoml.FileType;

/**
 *
 * @author in-rahul.khandelwal
 */
@MimeRegistration(mimeType = FileType.MIME, service = ParserFactory.class)
public class TomlParserFactory extends ParserFactory {

    @Override
    public Parser createParser(Collection<Snapshot> snapshots) {
        return new TomlEditorParser(TomlParserProvider.INSTANCE);
    }
}