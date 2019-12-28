package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ContractorContactDetailsService {

    @Autowired
    ContractorContactDetailsDAO contractorContactDetailsDAO;

    private ContractorContactDetails contractorContactDetailsGetter(Long id){
        return Optional.ofNullable(contractorContactDetailsDAO.findById(id)).orElse(new ContractorContactDetails());
    }

    public ContractorContactDetails findById(Long id){
        log.info("Checking if there is object to return.. " + id);
        return contractorContactDetailsGetter(id);
    }

    public void save(ContractorContactDetails contractorContactDetails){
        log.info("Saving new object: " + contractorContactDetails.toString());
        contractorContactDetailsDAO.save(contractorContactDetails);
        log.info("Saved: " + contractorContactDetails.getContractorContactDetailsId());
    }

    public Collection<ContractorContactDetails> findAll(){
        log.info("Getting objects from database: ");
        ArrayList<ContractorContactDetails> objects = new ArrayList<ContractorContactDetails>(contractorContactDetailsDAO.findAll());
        log.info("Returning array of objects: ");
        return objects;
    }

    public void delete(ContractorContactDetails contractorContactDetails){
        log.info("About to delete object: " + contractorContactDetails.getContractorContactDetailsId());
        contractorContactDetailsDAO.delete(contractorContactDetails);
        log.info("Deleted by object");
    }

    public void delete(Long id){
        log.info("About to delete object: " + id);
        contractorContactDetailsDAO.deleteById(id);
        log.info("Deleted by id");
    }
}