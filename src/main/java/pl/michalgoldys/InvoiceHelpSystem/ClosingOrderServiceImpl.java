package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClosingOrderServiceImpl implements ClosingOrder {

    @Autowired
    TimeService timeService;

    @Autowired
    AccountingOrderService accountingOrderService;

    @Override
    public void close(Long id) {

        AccountingOrder accountingOrder = accountingOrderGetter(id);

        if(isValidForClosing(accountingOrder)) {
            accountingOrder.getOrder().getOrderDetails().setIsClosed(true);
            accountingOrder.getOrder().getOrderDetails().setCloseDate(getCurrentTime());

            accountingOrderService.save(accountingOrder);
        }
    }

    private String getCurrentTime(){
        return timeService.getTime();
    }

    private Boolean isValidForClosing(AccountingOrder accountingOrder) {

        if (Optional.ofNullable(accountingOrder.getOrder().getOrderDetails().getIsClosed()).isPresent()) {
                if (accountingOrder.getOrder().getOrderDetails().getIsClosed()) {
                    return false;
                }
                else {
                    return true;
                }
            }
        else {
                return true;
        }
    }

    private AccountingOrder accountingOrderGetter(Long id){
        return accountingOrderService.findById(id);
    }
}