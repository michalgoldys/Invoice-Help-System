package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Objects;

public class Order {

    private final OrderType orderType;

    private Double amount;
    private String issueDate;

    public Order(OrderType orderType, Double amount, String issueDate) {
        this.orderType = orderType;
        this.amount = amount;
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType=" + orderType +
                ", amount=" + amount +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderType == order.orderType &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(issueDate, order.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderType, amount, issueDate);
    }
}
