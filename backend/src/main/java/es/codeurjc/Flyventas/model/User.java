package es.codeurjc.Flyventas.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="id_users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    
    private String nombre;
    private String apellido;
    private String email;
    private String address;
    private String encodedPassword;
    private boolean isAdmin;
    private boolean isBanned;

    /*@OneToMany(mappedBy = "user")
    private <List>Product products;*/

    public String getId() {
        return id;
    }

    public void setUser(String nombre, String apellido, String email, String address, String encodedPassword, boolean admin) {
    	this.nombre = nombre;
    	this.apellido = apellido;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.address = address;
        this.isAdmin = admin;
        this.isBanned = false; //nunca se va a crear un usuario baneado directamente
    }
    
    public String getnombre() {
        return nombre;
    }
    
    public String getapellido() {
        return apellido;
    }
    
    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
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

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        this.isBanned = banned;
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

	
    
    
}


