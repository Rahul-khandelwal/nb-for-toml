package com.rahul.nbfortoml;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 *
 * @author in-rahul.khandelwal
 */
public enum TomlLookupContext implements Lookup.Provider {
    INSTANCE;

    private final InstanceContent content;
    private final Lookup lookup;

    private TomlLookupContext() {
        this.content = new InstanceContent();
        this.lookup = new AbstractLookup(content);
    }

    @Override
    public Lookup getLookup() {
        return lookup;
    }

    public void add(Object inst) {
        content.add(inst);
    }

    public void remove(Object inst) {
        content.remove(inst);
    }
}