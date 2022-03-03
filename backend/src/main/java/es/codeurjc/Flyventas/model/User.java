package es.codeurjc.Flyventas.model;

import java.sql.Blob;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;;

    
    private String nombre;
    private String apellido;
    private String email;
    private String address;
    private String encodedPassword;
    private String categoria1;
    private String categoria2;
    private String categoria3;
    private boolean isAdmin;
    private boolean isBanned;
    private float assessment;

    /*@OneToMany(mappedBy = "user")
    private <List>Product products;*/

    public Long getId() {
        return id;
    }
    public User() {}
    
    public User(String nombre, String apellido, String email, String address, String encodedPassword, boolean admin, String categoria1, String categoria2, String categoria3) {
    	this.nombre = nombre;
    	this.apellido = apellido;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.address = address;
        this.isAdmin = admin;
        this.isBanned = false; //nunca se va a crear un usuario baneado directamente
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.categoria3 = categoria3;
    }

    public float getassessment() {
        return assessment;
    }

    public void setassessment(float assessment) {
        assessment = assessment;
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
    
    @Lob
	private Blob imageFile;

    
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
    
    public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, encodedPassword);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin && isBanned == user.isBanned && Float.compare(user.assessment, assessment) == 0 && Objects.equals(id, user.id) && Objects.equals(nombre, user.nombre) && Objects.equals(apellido, user.apellido) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(encodedPassword, user.encodedPassword) && Objects.equals(categoria1, user.categoria1) && Objects.equals(categoria2, user.categoria2) && Objects.equals(categoria3, user.categoria3) && Objects.equals(imageFile, user.imageFile);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", encodedPassword='" + encodedPassword + '\'' +
                ", categoria1='" + categoria1 + '\'' +
                ", categoria2='" + categoria2 + '\'' +
                ", categoria3='" + categoria3 + '\'' +
                ", isAdmin=" + isAdmin +
                ", isBanned=" + isBanned +
                ", Valoración=" + assessment +
                ", imageFile=" + imageFile +
                '}';
    }


	public String getCategoria1() {
		return categoria1;
	}
	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}
	public String getCategoria2() {
		return categoria2;
	}
	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}
	public String getCategoria3() {
		return categoria3;
	}
	public void setCategoria3(String categoria3) {
		this.categoria3 = categoria3;
	}

	
    
    
}


