package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class AccountingOrderService {

    @Autowired
    AccountingOrderDAO accountingOrderDAO;

    public void saveAccountingOrder(AccountingOrder accountingOrder){
            log.info("Saving new object: " + accountingOrder.toString());
            accountingOrderDAO.save(accountingOrder);
            log.info("Saved: " + accountingOrder.getAccountingOrderId());
    }

    public Collection<AccountingOrder> getAllAccountingOrder(){
        log.info("Getting objects from database: ");
        ArrayList<AccountingOrder> objects = new ArrayList<>(accountingOrderDAO.findAll());
        log.info("Returning array of objects: ");
        return objects;
    }

    public void deleteAccountingOrder(AccountingOrder accountingOrder){
        log.info("About to delete object: " + accountingOrder.getAccountingOrderId());
        accountingOrderDAO.delete(accountingOrder);
        log.info("Deleted");
    }

    public void deleteAccountingOrder(Long id){
        log.info("About to delete object: " + id);
        accountingOrderDAO.deleteById(id);
        log.info("Deleted");
    }
}