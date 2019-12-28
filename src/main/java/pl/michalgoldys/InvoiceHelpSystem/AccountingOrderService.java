package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class AccountingOrderService {

    @Autowired
    AccountingOrderDAO accountingOrderDAO;

    private AccountingOrder accountingOrderGetter(Long id){
        return Optional.ofNullable(accountingOrderDAO.findById(id)).orElse(new AccountingOrder());
    }

    public AccountingOrder findById(Long id){
        log.info("Checking if there is object to return.. ");
        return accountingOrderGetter(id);
    }

    public void save(AccountingOrder accountingOrder){
        log.info("Saving new object: " + accountingOrder.toString());
        accountingOrderDAO.save(accountingOrder);
        log.info("Saved: " + accountingOrder.getAccountingOrderId());
    }

    public Collection<AccountingOrder> findAll(){
        log.info("Getting objects from database: ");
        ArrayList<AccountingOrder> objects = new ArrayList<>(accountingOrderDAO.findAll());
        log.info("Returning array of objects: ");
        return objects;
    }

    public void delete(AccountingOrder accountingOrder){
        log.info("About to delete object: " + accountingOrder.getAccountingOrderId());
        accountingOrderDAO.delete(accountingOrder);
        log.info("Deleted by object");
    }

    public void delete(Long id){
        log.info("About to delete object: " + id);
        accountingOrderDAO.deleteById(id);
        log.info("Deleted by id");
    }
}