package es.codeurjc.Flyventas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="id_users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String encodedPassword;
    @Column
    private boolean isAdmin;
    @Column
    private boolean isBanned;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    private List<Product> productList;

    @OneToMany(mappedBy = "buyer")
    private List<Transaction> TransactionAsBuyerList;

    @OneToMany(mappedBy = "seller")
    private List<Transaction> TransactionAsSellerList;


    //Constructores

    public User() {}

    public User(String nombre, String apellido, String email, String address, String encodedPassword, boolean admin) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.address = address;
        this.isAdmin = admin;
        this.isBanned = false; //nunca se va a crear un usuario baneado directamente
        this.productList = new ArrayList<Product>();
    }


    @Override
    public int hashCode() {
        return Objects.hash(email, encodedPassword);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(email, other.email) && Objects.equals(encodedPassword, other.encodedPassword);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", address="
                + address + ", encodedPassword=" + encodedPassword + ", isAdmin=" + isAdmin + ", isBanned=" + isBanned
                + "]";
    }


    //Setters y Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        this.isBanned = banned;
    }


}


