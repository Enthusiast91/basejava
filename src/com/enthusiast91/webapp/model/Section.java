package com.enthusiast91.webapp.model;

public class Section {
    protected final SectionType type;

    public Section(SectionType type) {
        this.type = type;
    }

    public SectionType getType() {
        return type;
    }
}
