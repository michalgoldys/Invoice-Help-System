package pl.michalgoldys.InvoiceHelpSystem;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "company")
@Component
public class Company {

    private static Company companyInstance = null;

    @Id
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_street")
    private String companyStreet;
    @Column(name = "company_city")
    private String companyCity;
    @Column(name = "company_postal_code")
    private String companyPostalCode;
    @Column(name = "company_tax_number")
    private String companyTaxNumber;

    private Company(){
    }

    public static Company getInstance(){
        if(companyInstance == null){
           companyInstance = new Company();
        }
        return companyInstance;
    }
}