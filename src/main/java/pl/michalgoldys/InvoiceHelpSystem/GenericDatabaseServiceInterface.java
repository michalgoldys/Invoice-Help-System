package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Collection;

public interface GenericDatabaseServiceInterface<T> {

    T findById(Long id);
    void save(T t);
    Collection<T> findAll();
    void delete(T t);
    void delete(Long id);
}