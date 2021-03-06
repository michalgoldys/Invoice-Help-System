package pl.michalgoldys.InvoiceHelpSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountingOrderServiceTest {

    @Autowired
    AccountingOrderService accountingOrderService;

    @Test
    public void shouldSaveObjectWithoutException(){

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

        accountingOrderService.save(accountingOrder);

    }

    @Transactional
    @Test
    public void shouldGetAllAccountingOrderObjectsWithoutThrowingException(){
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

        accountingOrderService.save(accountingOrder);

        Collection<AccountingOrder> accountingOrder1 = new LinkedList<AccountingOrder>(accountingOrderService.findAll());

        accountingOrder1.forEach(a -> {
            System.out.println("Obiekt pobrany: " + a.toString());
            System.out.println("ID obiektu pobranego: " + a.getAccountingOrderId());
            a.getAccountingOrderId();
        });
    }

    @Test
    public void shouldDeleteAccountingOrderObjectWithoutThrowingException(){
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

        accountingOrderService.save(accountingOrder);

        accountingOrderService.delete(accountingOrder);
    }

    @Test
    public void shouldDeleteAccountingOrderByItsIdWithoutThrowingException(){

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

        accountingOrderService.save(accountingOrder);
        Collection<AccountingOrder> ac1 = new LinkedList<AccountingOrder>(accountingOrderService.findAll());
        Long id = null;
        for(AccountingOrder list : ac1)
        {
             id = list.getAccountingOrderId();
        }

        accountingOrderService.delete(id);
    }

    @Transactional
    @Test
    public void shouldGetByIdWithoutException(){

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

        accountingOrderService.save(accountingOrder);

        Collection<AccountingOrder> ac1 = new LinkedList<AccountingOrder>(accountingOrderService.findAll());
        Long id = null;
        for(AccountingOrder list : ac1)
        {
            id = list.getAccountingOrderId();
        }

        System.out.println(accountingOrderService.findById(id).toString());
    }

    @Test
    public void shouldReturnNewObjectInsteadOfThrowingException(){
        Long id = 2000000000L;

        System.out.println(accountingOrderService.findById(id).toString());
    }
}