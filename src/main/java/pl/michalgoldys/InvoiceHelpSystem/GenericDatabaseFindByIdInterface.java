package pl.michalgoldys.InvoiceHelpSystem;

public interface GenericDatabaseFindByIdInterface<T> {
    T findById(Long id);
}
