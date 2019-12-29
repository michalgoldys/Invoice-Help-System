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
public class ContractorContactDetailsServiceTest {

    @Autowired
    ContractorContactDetailsService contractorContactDetailsService;

    @Test
    public void shouldSaveWithoutException(){

        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("M")
                .setContactPersonSurname("G")
                .setContactMobile("123456789")
                .setContactStreet("Ogrodnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("00-000")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsService.save(contractorContactDetails);
    }

    @Test
    public void shouldGetAllObjectsWithoutException(){

        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("M")
                .setContactPersonSurname("G")
                .setContactMobile("123456789")
                .setContactStreet("Ogrodnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("00-000")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsService.save(contractorContactDetails);

        LinkedList<ContractorContactDetails> contractorLinkedList = new LinkedList<ContractorContactDetails>(contractorContactDetailsService.findAll());

        contractorLinkedList.forEach(a -> {
            System.out.println("Obiekt pobrany ID: " + a.getContractorContactDetailsId());
            System.out.println("Obiekt" + a.toString());
        });
    }

    @Test
    public void shouldDeleteByObjectWithoutException(){

        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("M")
                .setContactPersonSurname("G")
                .setContactMobile("123456789")
                .setContactStreet("Ogrodnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("00-000")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsService.save(contractorContactDetails);

        contractorContactDetailsService.delete(contractorContactDetails);
    }

    @Test
    public void shouldDeleteByIdWithoutException(){

        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("M")
                .setContactPersonSurname("G")
                .setContactMobile("123456789")
                .setContactStreet("Ogrodnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("00-000")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsService.save(contractorContactDetails);

        Collection<ContractorContactDetails> ac1 = new LinkedList<ContractorContactDetails>(contractorContactDetailsService.findAll());
        Long id = null;
        for(ContractorContactDetails list : ac1)
        {
            id = list.getContractorContactDetailsId();
        }

        contractorContactDetailsService.delete(id);
    }

    @Test
    public void shouldGetByIdWithoutException(){

        ContractorContactDetails contractorContactDetails = new ContractorContactDetails.Builder()
                .setContactPersonName("M")
                .setContactPersonSurname("G")
                .setContactMobile("123456789")
                .setContactStreet("Ogrodnicza")
                .setContactCity("Warszawa")
                .setContactPostalCode("00-000")
                .setContactEmailAddress("exmaple@example.com")
                .build();

        contractorContactDetailsService.save(contractorContactDetails);

        Collection<ContractorContactDetails> contractorLinkedList = new LinkedList<ContractorContactDetails>(contractorContactDetailsService.findAll());
        Long id = null;
        for(ContractorContactDetails list : contractorLinkedList)
        {
            id = list.getContractorContactDetailsId();
        }

        System.out.println(contractorContactDetailsService.findById(id).toString());
    }

    @Test
    public void shouldReturnNewObjectInsteadOfThrowingException(){
        Long id = 2000000000L;

        System.out.println(contractorContactDetailsService.findById(id).toString());
    }
}
