package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements GenericDatabaseServiceInterface<Order> {

    @Autowired
    OrderDAO orderDAO;

    private Order orderGetter(Long id){
        return Optional.ofNullable(orderDAO.findById(id)).orElse(new Order());
    }

    @Override
    public Order findById(Long id){
        log.info("Checking if there is ORDER object to return with ID: ");
        return orderGetter(id);
    }

    @Override
    public void save(Order order){
        log.info("Saving new ORDER object: " + order.toString());
        orderDAO.save(order);
    }

    @Override
    public Collection<Order> findAll(){
        log.info("Getting all ORDER objects from database");
        ArrayList<Order> objects = new ArrayList<Order>(orderDAO.findAll());
        return objects;
    }

    @Override
    public void delete(Order order){
        log.info("About to delete ORDER object with ID: " + order.getOrderId());
        orderDAO.delete(order);
    }

    @Override
    public void delete(Long id){
        log.info("About to delete ORDER object with ID: " + id);
        orderDAO.deleteById(id);
    }
}