package pl.michalgoldys.InvoiceHelpSystem;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractorId;

    @Column(name = "contractor_name")
    private String contractorName;
    @Column(name = "contractor_street")
    private String contractorStreet;
    @Column(name = "contractor_city")
    private String contractorCity;
    @Column(name = "contractor_postal_code")
    private String contractorPostalCode;
    @Column(name = "contractor_tax_number")
    private String contractorTaxNumber;

    public Long getContractorId() {
        return contractorId;
    }

    public Contractor setContractorId(Long contractorId) {
        this.contractorId = contractorId;
        return this;
    }

    public String getContractorName() {
        return contractorName;
    }

    public Contractor setContractorName(String contractorName) {
        this.contractorName = contractorName;
        return this;
    }

    public String getContractorStreet() {
        return contractorStreet;
    }

    public Contractor setContractorStreet(String contractorStreet) {
        this.contractorStreet = contractorStreet;
        return this;
    }

    public String getContractorCity() {
        return contractorCity;
    }

    public Contractor setContractorCity(String contractorCity) {
        this.contractorCity = contractorCity;
        return this;
    }

    public String getContractorPostalCode() {
        return contractorPostalCode;
    }

    public Contractor setContractorPostalCode(String contractorPostalCode) {
        this.contractorPostalCode = contractorPostalCode;
        return this;
    }

    public String getContractorTaxNumber() {
        return contractorTaxNumber;
    }

    public Contractor setContractorTaxNumber(String contractorTaxNumber) {
        this.contractorTaxNumber = contractorTaxNumber;
        return this;
    }

    protected Contractor(){
    }

    public Contractor(String contractorName, String contractorStreet, String contractorCity, String contractorPostalCode, String contractorTaxNumber) {
        this.contractorName = contractorName;
        this.contractorStreet = contractorStreet;
        this.contractorCity = contractorCity;
        this.contractorPostalCode = contractorPostalCode;
        this.contractorTaxNumber = contractorTaxNumber;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractorName='" + contractorName + '\'' +
                ", contractorStreet='" + contractorStreet + '\'' +
                ", contractorCity='" + contractorCity + '\'' +
                ", contractorPostalCode='" + contractorPostalCode + '\'' +
                ", contractorTaxNumber='" + contractorTaxNumber + '\'' +
                '}';
    }
}
