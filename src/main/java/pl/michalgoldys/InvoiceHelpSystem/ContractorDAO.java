package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface ContractorDAO extends Repository<Contractor, Long> {

    Collection<Contractor> findAll();
    Contractor delete(Contractor contractor);
    Contractor save(Contractor contractor);
    Contractor findById(Long contractorId);
    Contractor deleteById(Long id);
}
