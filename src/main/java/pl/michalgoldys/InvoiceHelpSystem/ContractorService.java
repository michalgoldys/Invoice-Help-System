package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class ContractorService implements GenericDatabaseServiceInterface<Contractor> {

    @Autowired
    ContractorDAO contractorDAO;

    private Contractor contractorGetter(Long id){
            return Optional.ofNullable(contractorDAO.findById(id)).orElse(new Contractor());
    }

    @Override
    public Contractor findById(Long id){
        log.info("Checking if there is CONTRACTOR object to return with ID: " + id);
        return contractorGetter(id);
    }

    @Override
    public void save(Contractor contractor){
        log.info("Saving new CONTRACTOR object: " + contractor.toString());
        contractorDAO.save(contractor);
    }

    @Override
    public Collection<Contractor> findAll(){
        log.info("Getting all CONTRACTOR objects from database");
        ArrayList<Contractor> objects = new ArrayList<Contractor>(contractorDAO.findAll());
        return objects;
    }

    @Override
    public void delete(Contractor contractor){
        log.info("About to delete CONTRACTOR object with ID: " + contractor.getContractorId());
        contractorDAO.delete(contractor);
    }

    @Override
    public void delete(Long id){
        log.info("About to delete CONTRACTOR object with ID: " + id);
        contractorDAO.deleteById(id);
    }
}