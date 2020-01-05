package pl.michalgoldys.InvoiceHelpSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ObjectCreationTest {

    @Autowired
    AccountingOrderDAO accountingOrderDAO;
    @Autowired
    ContractorDAO contractorDAO;
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ContractorContactDetailsDAO contractorContactDetailsDAO;

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfAccountingOrderObject(){

        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

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


        accountingOrderDAO.save(accountingOrder);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfOrderObject(){
        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderDAO.save(order);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfContractorObject(){
        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Ogrodnicza")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();

        contractorDAO.save(contractor);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfContractorContactDetailsObject(){
        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("Michal")
                .setContactPersonSurname("Goldys")
                .setContactMobile("730090992")
                .setContactStreet("Robotnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("02-261")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsDAO.save(contractorContactDetails);
    }
}