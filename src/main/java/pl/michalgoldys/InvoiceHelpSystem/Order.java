package pl.michalgoldys.InvoiceHelpSystem;

import javax.persistence.*;
import java.util.Objects;

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

    public OrderType getOrderType() {
        return orderType;
    }

    public Order setOrderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Order setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Order setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public Order setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
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

    public Order(OrderType orderType, OrderDetails orderDetails, Double amount, String issueDate, String description) {
        this.orderType = orderType;
        this.orderDetails = orderDetails;
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
