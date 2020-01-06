package pl.michalgoldys.InvoiceHelpSystem;

public interface GenericDatabaseSaveInterface<T> {
    void save(T t);
}