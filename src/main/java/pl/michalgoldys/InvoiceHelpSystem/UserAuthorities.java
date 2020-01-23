package pl.michalgoldys.InvoiceHelpSystem;

public enum UserAuthorities {
    ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");

    String role;

    UserAuthorities(String role) {
        this.role = role;
    }
}
