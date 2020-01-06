package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Collection;

public interface GenericDatabaseFindAllInterface<T> {
    Collection<T> findAll();
}
