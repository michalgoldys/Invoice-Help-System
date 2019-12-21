package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Objects;

public class AccountingOrder {

    private Order order;
    private Contractor contractor;
    private ContractorContactDetalis contractorContactDetalis;

    public AccountingOrder(Order order, Contractor contractor, ContractorContactDetalis contractorContactDetalis) {
        this.order = order;
        this.contractor = contractor;
        this.contractorContactDetalis = contractorContactDetalis;
    }

    @Override
    public String toString() {
        return "AccountingOrder{" +
                "order=" + order +
                ", contractor=" + contractor +
                ", contractorContactDetalis=" + contractorContactDetalis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingOrder that = (AccountingOrder) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(contractor, that.contractor) &&
                Objects.equals(contractorContactDetalis, that.contractorContactDetalis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, contractor, contractorContactDetalis);
    }
}