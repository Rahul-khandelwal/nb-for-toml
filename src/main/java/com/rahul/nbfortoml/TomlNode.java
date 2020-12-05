package com.rahul.nbfortoml;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TomlNode {

    private final String name;
    private final int type;
    private final int offset;

    public TomlNode(String name, int type, int offset) {
        this.name = name;
        this.type = type;
        this.offset = offset;
    }


    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

}
