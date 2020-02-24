package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CompanyService implements CompanyServiceInterface{

    @Autowired
    CompanySaveServiceImpl companySaveService;

    @Autowired
    CompanyGetByIdServiceImpl companyGetByIdService;

    private Company company = Company.getInstance();

    private static final Long ID = 1L;

    @Override
    public Company companyGetterService(){
        log.info("Checking if there is company entity to get..");
        if(Optional.ofNullable(companyGetByIdService.findById(ID)).isPresent()){
            log.info("Returning company entity");
            return  companyGetByIdService.findById(ID);
        }
        else {
            log.info("Returning company instance");
            return company;
        }
    }

    @Override
    public void companySaveService(Company company){
        log.info("Saving company entity");
        company.setCompanyId(ID);
        companySaveService.save(company);
    }
}