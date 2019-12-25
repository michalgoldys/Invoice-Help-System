package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "accounting_order")
public class AccountingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountingOrderId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contractor contractor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContractorContactDetails contractorContactDetails;

    public Long getAccountingOrderId() {
        return accountingOrderId;
    }

    protected AccountingOrder(){

    }

    public AccountingOrder(Order order, Contractor contractor, ContractorContactDetails contractorContactDetails) {
        this.order = order;
        this.contractor = contractor;
        this.contractorContactDetails = contractorContactDetails;
    }

    @Override
    public String toString() {
        return "AccountingOrder{" +
                "order=" + order +
                ", contractor=" + contractor +
                ", contractorContactDetails=" + contractorContactDetails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingOrder that = (AccountingOrder) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(contractor, that.contractor) &&
                Objects.equals(contractorContactDetails, that.contractorContactDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, contractor, contractorContactDetails);
    }
}