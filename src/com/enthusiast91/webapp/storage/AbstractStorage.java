package com.enthusiast91.webapp.storage;

import com.enthusiast91.webapp.exception.ExistStorageException;
import com.enthusiast91.webapp.exception.NotExistStorageException;
import com.enthusiast91.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage  {
    private static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract boolean isExist(SK searchKey);

    protected abstract List<Resume> doGetAll();

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract void doDelete(SK searchKey);

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(searchKey, resume);
    }

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> resumesList = doGetAll();
        Collections.sort(resumesList);
        return resumesList;
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume with UUID \"" + uuid + "\" doesn't exist.");
            throw new NotExistStorageException("Impossible to get this resume. ", uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume with UUID \"" + uuid + "\" already exist.");
            throw new ExistStorageException("Impossible to add this resume. ", uuid);
        }
        return searchKey;
    }
}