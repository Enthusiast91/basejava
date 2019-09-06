package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow");
            return;
        }
        int index = indexOf(resume.getUuid());
        if (index > 0) {
            System.out.println("Impossible to add this resume. Resume with UUID \"" + resume.getUuid() + "\" already exist.");
        } else {
            index = -index - 1;
            for (int i = size; i > index; i--) {
                storage[i] = storage[i - 1];
            }
            storage[index] = resume;
            size++;
        }
    }

    @Override
    protected void deleteImplementation(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
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
}