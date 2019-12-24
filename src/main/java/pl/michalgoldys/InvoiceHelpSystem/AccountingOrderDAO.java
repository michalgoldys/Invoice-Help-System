package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface AccountingOrderDAO extends Repository<AccountingOrder, Long> {

    Collection<AccountingOrder> findAll();
    AccountingOrder deleteByaccountingOrderId(Long accountingOrderId);
    AccountingOrder getOne(Long id);
    AccountingOrder save(AccountingOrder accountingOrder);
}