package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    private Order orderGetter(Long id){
        return Optional.ofNullable(orderDAO.findById(id)).orElse(new Order());
    }

    public Order findById(Long id){
        log.info("Checking if there is object to return.. ");
        return orderGetter(id);
    }

    public void save(Order order){
        log.info("Saving new object: " + order.toString());
        orderDAO.save(order);
        log.info("Saved: " + order.getOrderId());
    }

    public Collection<Order> findAll(){
        log.info("Getting objects from database: ");
        ArrayList<Order> objects = new ArrayList<Order>(orderDAO.findAll());
        log.info("Returning array of objects: ");
        return objects;
    }

    public void delete(Order order){
        log.info("About to delete object: " + order.getOrderId());
        orderDAO.delete(order);
        log.info("Deleted by object");
    }

    public void delete(Long id){
        log.info("About to delete object: " + id);
        orderDAO.deleteById(id);
        log.info("Deleted by id");
    }
}