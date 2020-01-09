package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Collection;

public interface AddressBookInterface<T> {

    void add(T t);
    void remove(T t);
    Collection<T> getAll();

}