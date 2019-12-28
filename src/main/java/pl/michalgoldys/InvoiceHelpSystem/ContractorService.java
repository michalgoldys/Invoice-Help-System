package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ContractorService {

    @Autowired
    ContractorDAO contractorDAO;

    private Contractor contractorGetter(Long id){
            return Optional.ofNullable(contractorDAO.findById(id)).orElse(new Contractor());
    }

    public Contractor findById(Long id){
        log.info("Checking if there is object to return.. " + id);
        return contractorGetter(id);
    }

    public void save(Contractor contractor){
        log.info("Saving new object: " + contractor.toString());
        contractorDAO.save(contractor);
        log.info("Saved: " + contractor.getContractorId());
    }

    public Collection<Contractor> findAll(){
        log.info("Getting objects from database: ");
        ArrayList<Contractor> objects = new ArrayList<Contractor>(contractorDAO.findAll());
        log.info("Returning array of objects: ");
        return objects;
    }

    public void delete(Contractor contractor){
        log.info("About to delete object: " + contractor.getContractorId());
        contractorDAO.delete(contractor);
        log.info("Deleted by object");
    }

    public void delete(Long id){
        log.info("About to delete object: " + id);
        contractorDAO.deleteById(id);
        log.info("Deleted by id");
    }
}