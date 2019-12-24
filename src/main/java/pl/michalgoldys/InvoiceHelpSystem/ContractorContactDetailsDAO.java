package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface ContractorContactDetailsDAO extends Repository<ContractorContactDetails, Long> {

    Collection<ContractorContactDetails> findAll();
    ContractorContactDetails deleteBycontractorContactDetailsId(Long contractorContactDetailsId);
    ContractorContactDetails getOne(Long contractorContactDetailsId);
    ContractorContactDetails save(ContractorContactDetails contractorContactDetails);
}
