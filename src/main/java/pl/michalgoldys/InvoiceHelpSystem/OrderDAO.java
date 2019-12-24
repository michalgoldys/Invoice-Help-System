package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface OrderDAO extends Repository<Order, Long> {

    Collection<Order> findAll();
    Order deleteByorderId(Long orderId);
    Order getOne(Long orderId);
    Order save(Order order);
}
