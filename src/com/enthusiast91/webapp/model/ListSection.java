package com.enthusiast91.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection<T>  extends Section {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = new ArrayList<>(list);
    }

    public ListSection(SectionType type, List<T> list) {
        super(type);
        this.list = new ArrayList<>(list);
    }

    public void addRecord(T record) {
        list.add(record);
    }

    public void insertRecord(int index, T record) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, record);
        }
    }

    public void addListRecords(List<T> list) {
        this.list.addAll(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection<?> that = (ListSection<?>) o;
        return type == that.type &&
                list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, list);
    }
}
