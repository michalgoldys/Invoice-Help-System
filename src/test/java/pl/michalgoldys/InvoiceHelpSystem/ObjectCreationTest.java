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


        accountingOrderDAO.save(accountingOrder);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfOrderObject(){
        Order order = new Order(OrderType.INVOICE, 400.00d,"01.01.2019","Test description");

        orderDAO.save(order);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfContractorObject(){
        Contractor contractor = new Contractor();
        contractor.setContractorStreet("Warszawska");
        contractor.setContractorCity("Warszawa");
        contractor.setContractorPostalCode("01-234");
        contractor.setContractorName("EXAMPLE");
        contractor.setContractorTaxNumber("1231232121");

        contractorDAO.save(contractor);
    }

    @Test
    public void shouldNotThrownExceptionDuringCreationAndSaveOfContractorContactDetailsObject(){
        ContractorContactDetails contractorContactDetails = new ContractorContactDetails();
        contractorContactDetails.setContactPersonName("M");
        contractorContactDetails.setContactPersonSurname("G");
        contractorContactDetails.setContactMobile("123456789");
        contractorContactDetails.setContactStreet("Ogrodnicza");
        contractorContactDetails.setContactCity("Warszawa");
        contractorContactDetails.setContactPostalCode("00-000");
        contractorContactDetails.setContactEmailAddress("exmaple@example.com");

        contractorContactDetailsDAO.save(contractorContactDetails);
    }
}