package pl.michalgoldys.InvoiceHelpSystem;

public enum TaxRate {
    FIVE(5), EIGHT(8), TWENTYTHREE(23);

    int taxValue;

    TaxRate(int taxValue) {
        this.taxValue = taxValue;
    }
}