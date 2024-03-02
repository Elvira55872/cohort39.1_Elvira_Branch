package repositories;

import dataModels.Reader;

import java.util.List;

public interface ReaderRepository {
    void addReader(Reader reader);
    void removeReader(Reader reader);
    List<Reader> findAllReaders();
}
