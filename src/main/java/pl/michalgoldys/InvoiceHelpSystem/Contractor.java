package pl.michalgoldys.InvoiceHelpSystem;

public class Contractor {

    private String contractorName;
    private String contractorStreet;
    private String contractorCity;
    private String contractorPostalCode;
    private String contractorTaxNubmer;

    private Contractor(String contractorName, String contractorStreet, String contractorCity, String contractorPostalCode, String contractorTaxNubmer) {
        this.contractorName = contractorName;
        this.contractorStreet = contractorStreet;
        this.contractorCity = contractorCity;
        this.contractorPostalCode = contractorPostalCode;
        this.contractorTaxNubmer = contractorTaxNubmer;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "contractorName='" + contractorName + '\'' +
                ", contractorStreet='" + contractorStreet + '\'' +
                ", contractorCity='" + contractorCity + '\'' +
                ", contractorPostalCode='" + contractorPostalCode + '\'' +
                ", contractorTaxNubmer='" + contractorTaxNubmer + '\'' +
                '}';
    }

    public static class Builder {

        private String contractorName;
        private String contractorStreet;
        private String contractorCity;
        private String contractorPostalCode;
        private String contractorTaxNubmer;

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

        public Builder setContractorTaxNubmer(String contractorTaxNubmer) {
            this.contractorTaxNubmer = contractorTaxNubmer;
            return this;
        }

        public Contractor build(){
            return new Contractor(contractorName, contractorStreet, contractorCity, contractorPostalCode, contractorTaxNubmer);
        }
    }
}
