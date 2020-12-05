package com.rahul.nbfortoml.codeFolding;

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.fold.FoldManager;
import org.netbeans.spi.editor.fold.FoldManagerFactory;

import com.rahul.nbfortoml.FileType;

/**
 *
 * @author in-rahul.khandelwal
 */
@MimeRegistration(mimeType = FileType.MIME, service = FoldManagerFactory.class)
public class TomlFoldManagerFactory implements FoldManagerFactory {

    @Override
    public FoldManager createFoldManager() {
        return new TomlFoldManager();
    }

}
