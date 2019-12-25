package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "order_table")
public class Order {

    private OrderType orderType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "amount")
    private Double amount;
    @Column(name = "issue_date")
    private String issueDate;

    public Long getOrderId() {
        return orderId;
    }

    protected Order(){

    }

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
