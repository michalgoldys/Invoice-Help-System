package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Objects;

public class AccountingOrder {

    private Order order;
    private Contractor contractor;
    private ContractorContactDetails contractorContactDetails;

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