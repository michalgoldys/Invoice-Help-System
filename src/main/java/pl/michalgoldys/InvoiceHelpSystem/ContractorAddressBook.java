package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Component
@Entity(name = "contractor_address_book")
public class ContractorAddressBook implements AddressBookInterface<Contractor> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractorAddressBookId;

    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<Contractor> contractorAddressBook;

    protected ContractorAddressBook(){
    }

    @Override
    public void add(Contractor contractor) {
        addressBookManager().add(contractor);
    }

    @Override
    public void remove(Contractor contractor) {
        addressBookManager().remove(contractor);
    }

    @Override
    public Collection<Contractor> getAll() {
        return addressBookManager();
    }

    private Collection<Contractor> addressBookManager() {
       if (contractorAddressBook == null){
           contractorAddressBook = new ArrayList<Contractor>();
       }
        return contractorAddressBook;
    }
}