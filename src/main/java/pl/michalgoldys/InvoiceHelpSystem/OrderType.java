package pl.michalgoldys.InvoiceHelpSystem;

public enum OrderType {
    INVOICE("Faktura"), REINVOICE("Refaktura");

    String name;

    OrderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
