package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class AccountingOrderService implements GenericDatabaseServiceInterface<AccountingOrder> {

    @Autowired
    AccountingOrderDAO accountingOrderDAO;

    private AccountingOrder accountingOrderGetter(Long id){
        return Optional.ofNullable(accountingOrderDAO.findById(id)).orElse(new AccountingOrder());
    }

    @Override
    public AccountingOrder findById(Long id){
        log.info("Checking if there is ACCOUNTING ORDER object to return with ID: " + id);
        return accountingOrderGetter(id);
    }

    @Override
    public void save(AccountingOrder accountingOrder){
        log.info("Saving new ACCOUNTING ORDER object: " + accountingOrder.toString());
        accountingOrderDAO.save(accountingOrder);
        log.info("Saved: " + accountingOrder.getAccountingOrderId());
    }

    @Override
    public Collection<AccountingOrder> findAll(){
        log.info("Getting all ACCOUNTING ORDER objects from database ");
        ArrayList<AccountingOrder> objects = new ArrayList<AccountingOrder>(accountingOrderDAO.findAll());
        return objects;
    }

    @Override
    public void delete(AccountingOrder accountingOrder){
        log.info("About to delete ACCOUNTING ORDER object with ID: " + accountingOrder.getAccountingOrderId());
        accountingOrderDAO.delete(accountingOrder);
    }

    @Override
    public void delete(Long id){
        log.info("About to delete ACCOUNTING ORDER object by id: " + id);
        accountingOrderDAO.deleteById(id);
    }
}