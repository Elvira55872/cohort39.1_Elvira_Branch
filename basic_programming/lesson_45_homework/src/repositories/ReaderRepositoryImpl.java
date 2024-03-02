package repositories;

import dataModels.Reader;

import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private List<Reader> readers;

    public ReaderRepositoryImpl(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public void addReader(Reader reader) {
        if (readers.contains(reader)) {
            System.out.println("This reader is already existing");
        } else {
            readers.add(reader);
        }
    }

    @Override
    public void removeReader(Reader reader) {
        if (readers.contains(reader)){
            readers.remove(reader);
        }else {
            System.out.println("This reader doesnt exist");
        }
    }

    @Override
    public List<Reader> findAllReaders() {
        return readers;
    }
}
