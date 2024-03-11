package practice.repositories;

import practice.interfaces.ReaderRepository;
import practice.models.Reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private List<Reader> readers;

    public ReaderRepositoryImpl() {
        readers = new ArrayList<>();
    }

    public ReaderRepositoryImpl(Collection<Reader> readers) {
        this.readers = new ArrayList<>(readers);
    }

    @Override
    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    @Override
    public List<Reader> findAllReaders() {
        return readers;
    }

    @Override
    public boolean removeReader(Reader reader) {
        return readers.remove(reader);
    }
}
