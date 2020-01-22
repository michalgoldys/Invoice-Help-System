package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.data.repository.Repository;

public interface CompanyDAO extends Repository<Company, Long> {

    Company save(Company company);
    Company findById(Long companyId);
}
