package pl.michalgoldys.InvoiceHelpSystem;

public enum PaymentPeroid {
    SEVEN(7), FOURTEEN(14), THIRTY(30), SIXTY(60);

    int paymentPeriod;

    PaymentPeroid(int paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }
}
