package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface ContractorContactDetailsDAO extends Repository<ContractorContactDetails, Long> {

    Collection<ContractorContactDetails> findAll();
    ContractorContactDetails delete(ContractorContactDetails contractorContactDetails);
    ContractorContactDetails save(ContractorContactDetails contractorContactDetails);
    ContractorContactDetails findById(Long contractorContactDetailsId);
    ContractorContactDetails deleteById(Long id);
}