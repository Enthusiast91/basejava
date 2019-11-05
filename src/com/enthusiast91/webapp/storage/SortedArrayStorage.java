package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedArrayStorage extends AbstractArrayStorage implements Storage {

//    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void fillDeletedElement(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        Integer resume = (Integer) searchKey;
        return resume >= 0;
    }

    /**
     * @return index of the search key, if it is contained in the array;
     *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
     *         <i>insertion point</i> is defined as the point at which the
     *         key would be inserted into the array: the index of the first
     *         element greater than the key, or <tt>a.length</tt> if all
     *         elements in the array are less than the specified key.
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid), RESUME_COMPARATOR);
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void resumesListSort(List<Resume> listResume) {
        listResume.sort(Comparator.comparing(Resume::getFullName));
    }
}