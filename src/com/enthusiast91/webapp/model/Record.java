package com.enthusiast91.webapp.model;

import java.util.Objects;

public class Record {
    private String organization;
    private String period;
    private String position;
    private String description;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Record(String organization, String period, String position) {
        this.organization = organization;
        this.period = period;
        this.position = position;
    }

    public Record(String organization, String period, String position, String description) {
        this.organization = organization;
        this.period = period;
        this.position = position;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return organization.equals(record.organization) &&
                period.equals(record.period) &&
                position.equals(record.position) &&
                Objects.equals(description, record.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization, period, position, description);
    }
}