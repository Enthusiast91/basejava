package com.enthusiast91.webapp.model;

import java.util.Objects;

public class Contact {
    protected final ContactType type;
    protected String value;

    public ContactType getContactType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Contact(ContactType type) {
        this.type = type;
    }

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return type == contact.type &&
                value.equals(contact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }


}