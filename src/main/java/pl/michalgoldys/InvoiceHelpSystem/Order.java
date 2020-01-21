package pl.michalgoldys.InvoiceHelpSystem;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity(name = "order_table")
public class Order {

    @Column(name = "order_type")
    @Enumerated(value = EnumType.STRING)
    private OrderType orderType;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private OrderDetails orderDetails;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "amount")
    private Double amount;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name ="description")
    private String description;

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    protected Order(){

    }

    public Order(OrderType orderType, Double amount, String issueDate, String description) {
        this.orderType = orderType;
        this.amount = amount;
        this.issueDate = issueDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType=" + orderType +
                ", amount=" + amount +
                ", issueDate='" + issueDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderType == order.orderType &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(issueDate, order.issueDate) &&
                Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderType, amount, issueDate, description);
    }
}
