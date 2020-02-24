package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@Slf4j
public class DatabaseLoader {

    @Autowired
    AccountingOrderService accountingOrderService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDAO userDAO;
    @Bean
    CommandLineRunner initDatabase(){
        return args ->{

            log.info("Checking if there is any object to present.. ");

            if(accountingOrderService.findAll().isEmpty())
            {
                log.info("Creating example objects..");

                Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019", "testowy opis obiektu");
                OrderDetails orderDetails = new OrderDetails(OrderMode.CONTINUOUS);

                orderDetails.setOrder(order);
                order.setOrderDetails(orderDetails);

                Contractor contractor = new Contractor();
                contractor.setContractorStreet("Warszawska");
                contractor.setContractorCity("Warszawa");
                contractor.setContractorPostalCode("01-234");
                contractor.setContractorName("EXAMPLE");
                contractor.setContractorTaxNumber("1231232121");

                ContractorContactDetails contractorContactDetails = new ContractorContactDetails();
                contractorContactDetails.setContactPersonName("M");
                contractorContactDetails.setContactPersonSurname("G");
                contractorContactDetails.setContactMobile("123456789");
                contractorContactDetails.setContactStreet("Ogrodnicza");
                contractorContactDetails.setContactCity("Warszawa");
                contractorContactDetails.setContactPostalCode("00-000");
                contractorContactDetails.setContactEmailAddress("exmaple@example.com");

                AccountingOrder accountingOrder = new AccountingOrder(order,contractor, contractorContactDetails);
                log.info("Saving database entites:... " + accountingOrder);
                accountingOrderService.save(accountingOrder);
                log.info("Saved");
            }

            log.info("Checing if there is default user..");

            if(!Optional.ofNullable(userDAO.findByusername("admin")).isPresent())
            {
                log.info("Creating default admin  user");

                User user = new User("admin",passwordEncoder.encode("admin1234"),true);
                UserRoles userRoles = new UserRoles(UserAuthorities.ROLE_ADMIN.toString());

                log.info("ROLE: " + UserAuthorities.ROLE_ADMIN.toString());

                List<UserRoles> listUserRoles = new ArrayList<UserRoles>();
                listUserRoles.add(userRoles);

                user.setUserRoles(listUserRoles);
                userRoles.setUser(user);

                userDAO.save(user);
                listUserRoles.clear();
            }
        };
    }
}
