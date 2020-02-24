package pl.michalgoldys.InvoiceHelpSystem;

public enum OrderMode {

    SINGLE_TIME("Pojedyncze"), CONTINUOUS("Powtarzalne");

    String name;

    OrderMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

