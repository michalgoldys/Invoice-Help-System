package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface ContractorDAO extends Repository<Contractor, Long> {

    Collection<Contractor> findAll();
    Contractor deleteBycontractorId(Long contractorId);
    Contractor getOne(Long contractorId);
    Contractor save(Contractor contractor);
}
