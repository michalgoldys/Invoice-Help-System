package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "user_roles")
public class UserRoles {

    @Id
    @Column(name = "authority")
    private String authority;

    @Autowired
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private UserRoles() {
    }

    public UserRoles(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public UserRoles setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserRoles setUser(User user) {
        this.user = user;
        return this;
    }
}
