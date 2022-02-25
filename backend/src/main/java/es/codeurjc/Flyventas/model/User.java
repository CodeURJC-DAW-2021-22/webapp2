package es.codeurjc.Flyventas.model;

import javax.persistence.*;

@Entity
@Table(name="id_users")
public class User {

    @Id
    private String id;

    private String email;
    private String address;
    private boolean isAdmin;
    private boolean isBanned;

    /*@OneToMany(mappedBy = "user")
    private <List>Product products;*/

    public String getId() {
        return id;
    }

    public void setUser(String id, String email, String address, boolean admin) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.isAdmin = admin;
        this.isBanned = false; //nunca se va a crear un usuario baneado directamente
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        this.isBanned = banned;
    }
}


