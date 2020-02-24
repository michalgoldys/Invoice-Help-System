package pl.michalgoldys.InvoiceHelpSystem;

import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity(name = "contractor_contact_details")
public class ContractorContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractorContactDetailsId;

    @Column(name = "contact_email_address")
    private String contactEmailAddress;
    @Column(name = "contact_street")
    private String contactStreet;
    @Column(name = "contact_city")
    private String contactCity;
    @Column(name = "contact_postal_code")
    private String contactPostalCode;
    @Column(name = "contact_person_name")
    private String contactPersonName;
    @Column(name = "contact_person_surname")
    private String contactPersonSurname;
    @Column(name = "contact_mobile")
    private String contactMobile;

    public Long getContractorContactDetailsId() {
        return contractorContactDetailsId;
    }

    public ContractorContactDetails setContractorContactDetailsId(Long contractorContactDetailsId) {
        this.contractorContactDetailsId = contractorContactDetailsId;
        return this;
    }

    public String getContactEmailAddress() {
        return contactEmailAddress;
    }

    public ContractorContactDetails setContactEmailAddress(String contactEmailAddress) {
        this.contactEmailAddress = contactEmailAddress;
        return this;
    }

    public String getContactStreet() {
        return contactStreet;
    }

    public ContractorContactDetails setContactStreet(String contactStreet) {
        this.contactStreet = contactStreet;
        return this;
    }

    public String getContactCity() {
        return contactCity;
    }

    public ContractorContactDetails setContactCity(String contactCity) {
        this.contactCity = contactCity;
        return this;
    }

    public String getContactPostalCode() {
        return contactPostalCode;
    }

    public ContractorContactDetails setContactPostalCode(String contactPostalCode) {
        this.contactPostalCode = contactPostalCode;
        return this;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public ContractorContactDetails setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
        return this;
    }

    public String getContactPersonSurname() {
        return contactPersonSurname;
    }

    public ContractorContactDetails setContactPersonSurname(String contactPersonSurname) {
        this.contactPersonSurname = contactPersonSurname;
        return this;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public ContractorContactDetails setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
        return this;
    }

    protected ContractorContactDetails(){
    }

    public ContractorContactDetails(String contactEmailAddress, String contactStreet, String contactCity, String contactPostalCode, String contactPersonName, String contactPersonSurname, String contactMobile) {
        this.contactEmailAddress = contactEmailAddress;
        this.contactStreet = contactStreet;
        this.contactCity = contactCity;
        this.contactPostalCode = contactPostalCode;
        this.contactPersonName = contactPersonName;
        this.contactPersonSurname = contactPersonSurname;
        this.contactMobile = contactMobile;
    }

    @Override
    public String toString() {
        return "ContractorContactDetails{" +
                "contactEmailAddress='" + contactEmailAddress + '\'' +
                ", contactStreet='" + contactStreet + '\'' +
                ", contactCity='" + contactCity + '\'' +
                ", contactPostalCode='" + contactPostalCode + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactPersonSurname='" + contactPersonSurname + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorContactDetails that = (ContractorContactDetails) o;
        return Objects.equals(contactEmailAddress, that.contactEmailAddress) &&
                Objects.equals(contactStreet, that.contactStreet) &&
                Objects.equals(contactCity, that.contactCity) &&
                Objects.equals(contactPostalCode, that.contactPostalCode) &&
                Objects.equals(contactPersonName, that.contactPersonName) &&
                Objects.equals(contactPersonSurname, that.contactPersonSurname) &&
                Objects.equals(contactMobile, that.contactMobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactEmailAddress, contactStreet, contactCity, contactPostalCode, contactPersonName, contactPersonSurname, contactMobile);
    }
}