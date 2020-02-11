package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountingOrderSaveService implements GenericDatabaseSaveInterface<AccountingOrder> {

    @Autowired
    private AccountingOrderDAO accountingOrderDAO;

    @Override
    public void save(AccountingOrder accountingOrder) {
        log.info("About to save Accounting Order Object: " + accountingOrder);
        accountingOrderDAO.save(accountingOrder);
    }
}
