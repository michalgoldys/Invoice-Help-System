package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyGetByIdServiceImpl implements GenericDatabaseFindByIdInterface<Company> {

    @Autowired
    CompanyDAO companyDAO;

    @Override
    public Company findById(Long id) {
        return companyDAO.findById(id);
    }
}
