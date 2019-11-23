package com.enthusiast91.webapp.model;

import java.util.Objects;

public class TextSection extends Section {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextSection(SectionType type, String text) {
        super(type);
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return type == that.type &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, text);
    }
}
