package pl.michalgoldys.InvoiceHelpSystem;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    public static Company getCompanyInstance() {
        return companyInstance;
    }

    public static void setCompanyInstance(Company companyInstance) {
        Company.companyInstance = companyInstance;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Company setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyStreet() {
        return companyStreet;
    }

    public Company setCompanyStreet(String companyStreet) {
        this.companyStreet = companyStreet;
        return this;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public Company setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
        return this;
    }

    public String getCompanyPostalCode() {
        return companyPostalCode;
    }

    public Company setCompanyPostalCode(String companyPostalCode) {
        this.companyPostalCode = companyPostalCode;
        return this;
    }

    public String getCompanyTaxNumber() {
        return companyTaxNumber;
    }

    public Company setCompanyTaxNumber(String companyTaxNumber) {
        this.companyTaxNumber = companyTaxNumber;
        return this;
    }

    public static Company getInstance(){
        if(companyInstance == null){
           companyInstance = new Company();
        }
        return companyInstance;
    }
}