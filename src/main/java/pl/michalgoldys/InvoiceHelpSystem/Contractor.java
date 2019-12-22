package pl.michalgoldys.InvoiceHelpSystem;

import javax.persistence.*;

@Entity(name = "contractor")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    private Contractor(String contractorName, String contractorStreet, String contractorCity, String contractorPostalCode, String contractorTaxNumber) {
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

    public static class Builder {

        private String contractorName;
        private String contractorStreet;
        private String contractorCity;
        private String contractorPostalCode;
        private String contractorTaxNumber;

        public Builder setContractorName(String contractorName) {
            this.contractorName = contractorName;
            return this;
        }

        public Builder setContractorStreet(String contractorStreet) {
            this.contractorStreet = contractorStreet;
            return this;
        }

        public Builder setContractorCity(String contractorCity) {
            this.contractorCity = contractorCity;
            return this;
        }

        public Builder setContractorPostalCode(String contractorPostalCode) {
            this.contractorPostalCode = contractorPostalCode;
            return this;
        }

        public Builder setContractorTaxNumber(String contractorTaxNumber) {
            this.contractorTaxNumber = contractorTaxNumber;
            return this;
        }

        public Contractor build(){
            return new Contractor(contractorName, contractorStreet, contractorCity, contractorPostalCode, contractorTaxNumber);
        }
    }
}
