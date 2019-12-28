package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface AccountingOrderDAO extends Repository<AccountingOrder, Long> {

    Collection<AccountingOrder> findAll();
    AccountingOrder delete(AccountingOrder accountingOrder);
    AccountingOrder save(AccountingOrder accountingOrder);
    AccountingOrder findById(Long accountingOrderId);
    AccountingOrder deleteById(Long id);
}