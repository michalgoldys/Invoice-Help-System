package pl.michalgoldys.InvoiceHelpSystem;

import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name="order_details")
public class OrderDetails {

    @Column(name = "order_mode")
    @Enumerated(value = EnumType.STRING)
    private OrderMode orderMode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderModeId;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name ="isClosed")
    private Boolean isClosed;

    @Column(name ="close_date")
    private String closeDate;

    public OrderMode getOrderMode() {
        return orderMode;
    }

    public OrderDetails setOrderMode(OrderMode orderMode) {
        this.orderMode = orderMode;
        return this;
    }

    public Long getOrderModeId() {
        return orderModeId;
    }

    public OrderDetails setOrderModeId(Long orderModeId) {
        this.orderModeId = orderModeId;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDetails setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public OrderDetails setIsClosed(Boolean closed) {
        isClosed = closed;
        return this;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public OrderDetails setCloseDate(String closeDate) {
        this.closeDate = closeDate;
        return this;
    }

    protected OrderDetails(){
    }

    public OrderDetails(OrderMode orderMode) {
        this.orderMode = orderMode;
    }
}
