package pl.michalgoldys.InvoiceHelpSystem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity(name="order_details")
public class OrderDetails {

    @Column(name = "order_mode")
    @Enumerated(value = EnumType.STRING)
    @Getter
    private OrderMode orderMode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    Long orderModeId;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Getter
    @Setter
    @Column(name ="isClosed")
    private Boolean isClosed;

    @Getter
    @Setter
    @Column(name ="close_date")
    private String closeDate;

    protected OrderDetails(){
    }

    public OrderDetails(OrderMode orderMode) {
        this.orderMode = orderMode;
    }
}
