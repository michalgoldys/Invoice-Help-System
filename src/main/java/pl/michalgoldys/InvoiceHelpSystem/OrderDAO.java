package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface OrderDAO extends Repository<Order, Long> {

    Collection<Order> findAll();
    Order delete(Order order);
    Order save(Order order);
    Order findById(Long orderId);
    Order deleteById(Long id);
}