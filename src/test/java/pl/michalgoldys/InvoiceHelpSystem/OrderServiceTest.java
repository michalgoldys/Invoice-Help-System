package pl.michalgoldys.InvoiceHelpSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.LinkedList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void shouldSaveWithoutException(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderService.save(order);
    }

    @Test
    public void shouldGetAllObjectsWithoutException(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderService.save(order);

        LinkedList<Order> orderLinkedListList = new LinkedList<Order>(orderService.findAll());

        orderLinkedListList.forEach(a -> {
            System.out.println("Obiekt pobrany ID: " + a.getOrderId());
            System.out.println("Obiekt" + a.toString());
        });
    }

    @Test
    public void shouldDeleteByObjectWithoutException(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderService.save(order);

        orderService.delete(order);
    }

    @Test
    public void shouldDeleteByIdWithoutException(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderService.save(order);

        Collection<Order> ac1 = new LinkedList<Order>(orderService.findAll());
        Long id = null;
        for(Order list : ac1)
        {
            id = list.getOrderId();
        }

        orderService.delete(id);
    }

    @Test
    public void shouldGetByIdWithoutException(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderService.save(order);

        Collection<Order> ac1 = new LinkedList<Order>(orderService.findAll());
        Long id = null;
        for(Order list : ac1)
        {
            id = list.getOrderId();
        }

        System.out.println(orderService.findById(id).toString());
    }

    @Test
    public void shouldReturnNewObjectInsteadOfThrowingException(){
        Long id = 2000000000L;

        System.out.println(orderService.findById(id).toString());
    }
}
