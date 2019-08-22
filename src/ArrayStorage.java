/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    //Выделил общий размер хранилищая в отдельную переменную maxSize. Предполагая что в будущем хранилище может
    // увеличиваться при добавлении новых записей
    private int maxSize = 10000;
    private Resume[] storage = new Resume[maxSize];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size == maxSize) {
            storage = createStorageWithNewMaxSize();
        }
        storage[size] = r;
        size++;
    }

    // создание нового массива при переполнении старого
    private Resume[] createStorageWithNewMaxSize() {
        maxSize += (maxSize / 2);
        Resume[] newStorage = new Resume[maxSize];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                for (int j = i + 1; j < size; j++) {
                    storage[j - 1] = storage[j];
                }
                size--;
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tempArr = new Resume[size];
        for (int i = 0; i < size; i++) {
            tempArr[i] = storage[i];
        }
        return tempArr;
    }

    int size() {
        return size;
    }
}
