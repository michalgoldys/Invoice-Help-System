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
public class ContractorServiceTest {

    @Autowired
    ContractorService contractorService;

    @Test
    public void shouldSaveWithoutException(){

        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Warszawska")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();
        contractorService.save(contractor);
    }

    @Test
    public void shouldGetAllObjectsWithoutException(){

        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Warszawska")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();
        contractorService.save(contractor);

        LinkedList<Contractor> contractorLinkedList = new LinkedList<Contractor>(contractorService.findAll());

        contractorLinkedList.forEach(a -> {
                System.out.println("Obiekt pobrany ID: " + a.getContractorId());
                System.out.println("Obiekt" + a.toString());
        });
    }

    @Test
    public void shouldDeleteByObjectWithoutException(){

        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Warszawska")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();

        contractorService.save(contractor);

        contractorService.delete(contractor);
    }

    @Test
    public void shouldDeleteByIdWithoutException(){

        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Warszawska")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();

        contractorService.save(contractor);

        Collection<Contractor> ac1 = new LinkedList<Contractor>(contractorService.findAll());
        Long id = null;
        for(Contractor list : ac1)
        {
            id = list.getContractorId();
        }

        contractorService.delete(id);
    }

    @Test
    public void shouldGetByIdWithoutException(){

        Contractor contractor = new Contractor.Builder()
                .setContractorStreet("Warszawska")
                .setContractorCity("Warszawa")
                .setContractorPostalCode("01-234")
                .setContractorName("EXAMPLE")
                .setContractorTaxNumber("1231232121")
                .build();

        contractorService.save(contractor);

        Collection<Contractor> contractorLinkedList = new LinkedList<Contractor>(contractorService.findAll());
        Long id = null;
        for(Contractor list : contractorLinkedList)
        {
            id = list.getContractorId();
        }

        System.out.println(contractorService.findById(id).toString());
    }

    @Test
    public void shouldReturnNewObjectInsteadOfThrowingException(){
        Long id = 2000000000L;

        System.out.println(contractorService.findById(id).toString());
    }
}
