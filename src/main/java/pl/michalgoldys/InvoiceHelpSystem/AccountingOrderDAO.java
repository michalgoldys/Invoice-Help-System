package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface AccountingOrderDAO extends Repository<AccountingOrder, Long> {

    Collection<AccountingOrder> findAll();
    void delete(AccountingOrder accountingOrder);
    void save(AccountingOrder accountingOrder);
    AccountingOrder findById(Long accountingOrderId);
    void deleteById(Long id);
}