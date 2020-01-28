package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanySaveServiceImpl implements GenericDatabaseSaveInterface<Company> {

    @Autowired
    CompanyDAO companyDAO;

    private final static Long ID = 1L;

    @Override
    public void save(Company company) {
        if(company.getCompanyId() != ID)
        {
            company.setCompanyId(ID);
        }
        companyDAO.save(company);
    }
}
