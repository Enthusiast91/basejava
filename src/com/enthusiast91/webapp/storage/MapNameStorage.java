package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public class MapNameStorage extends MapUuidStorage {
    @Override
    protected void resumesListSort(List<Resume> listResume) {
        listResume.sort(Comparator.comparing(r -> (r.getFullName() + r.getUuid())));
    }
}