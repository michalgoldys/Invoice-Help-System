package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ContractorContactDetailsService implements GenericDatabaseServiceInterface<ContractorContactDetails> {

    @Autowired
    ContractorContactDetailsDAO contractorContactDetailsDAO;

    private ContractorContactDetails contractorContactDetailsGetter(Long id){
        return Optional.ofNullable(contractorContactDetailsDAO.findById(id)).orElse(new ContractorContactDetails());
    }

    @Override
    public ContractorContactDetails findById(Long id){
        log.info("Checking if there is CONTRACTOR CONTACT DETAILS object to return with ID: " + id);
        return contractorContactDetailsGetter(id);
    }

    @Override
    public void save(ContractorContactDetails contractorContactDetails){
        log.info("Saving new CONTRACTOR CONTACT DETAILS object: " + contractorContactDetails.toString());
        contractorContactDetailsDAO.save(contractorContactDetails);
    }

    @Override
    public Collection<ContractorContactDetails> findAll(){
        log.info("Getting all CONTRACTOR CONTACT DETAILS objects from database ");
        ArrayList<ContractorContactDetails> objects = new ArrayList<ContractorContactDetails>(contractorContactDetailsDAO.findAll());
        return objects;
    }

    @Override
    public void delete(ContractorContactDetails contractorContactDetails){
        log.info("About to delete CONTRACTOR CONTACT DETAILS object with ID:  " + contractorContactDetails.getContractorContactDetailsId());
        contractorContactDetailsDAO.delete(contractorContactDetails);
    }

    @Override
    public void delete(Long id){
        log.info("About to delete CONTRACTOR CONTACT DETAILS object with ID: " + id);
        contractorContactDetailsDAO.deleteById(id);
    }
}