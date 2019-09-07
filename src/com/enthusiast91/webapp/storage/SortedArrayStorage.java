package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage implements Storage {

    @Override
    protected void deleteImplementation(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
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
    protected int indexOf(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid));
    }

    @Override
    protected void insert(int index, Resume resume) {
        index = -index - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }
}