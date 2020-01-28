package pl.michalgoldys.InvoiceHelpSystem;

public enum PaymentPeriod {
    SEVEN(7), FOURTEEN(14), THIRTY(30), SIXTY(60);

    int paymentPeriod;

    PaymentPeriod(int paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }
}
