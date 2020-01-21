package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DatabaseLoader {

    @Autowired
    AccountingOrderService accountingOrderService;

    @Bean
    CommandLineRunner initDatabase(){
        return args ->{

            Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019", "testowy opis obiektu");
            OrderDetails orderDetails = new OrderDetails(OrderMode.CONTIOUS);

            orderDetails.setOrder(order);
            order.setOrderDetails(orderDetails);

            Contractor contractor = new Contractor.Builder()
                    .setContractorStreet("Warszawska")
                    .setContractorCity("Warszawa")
                    .setContractorPostalCode("01-234")
                    .setContractorName("EXAMPLE")
                    .setContractorTaxNumber("1231232121")
                    .build();

            ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                    .setContactPersonName("M")
                    .setContactPersonSurname("G")
                    .setContactMobile("123456789")
                    .setContactStreet("Ogrodnicza")
                    .setContactCity("Warszawa")
                    .setContactPostalCode("00-000")
                    .setContactEmailAddress("exmaple@example.com")
                    .build();

            AccountingOrder accountingOrder = new AccountingOrder(order,contractor, contractorContactDetails);
            log.info("Saving database entites:... " + accountingOrder);
            accountingOrderService.save(accountingOrder);
            log.info("Saved");
        };
    }
}
