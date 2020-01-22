package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanySaveServiceImpl implements GenericDatabaseSaveInterface<Company> {

    @Autowired
    CompanyDAO companyDAO;

    @Override
    public void save(Company company) {
        companyDAO.save(company);
    }
}
