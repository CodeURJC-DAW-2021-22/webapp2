package es.codeurjc.Flyventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table (name="Customer")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    
    private String name;
    private String surname;
    private String email;
    private String address;
    private String encodedPassword;
    private String categoria1;
    private String categoria2;
    private String categoria3;

	@Lob
	private Blob imageFile;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Product> productList;

	@OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
	private List<Counteroffer> counterofferList = new ArrayList<>();

	@OneToMany(mappedBy = "seller", cascade = CascadeType.REMOVE)
	private List<Transaction> transactionList = new ArrayList<>();



	//Constructores

	public User() {}

    public User(String name, String apellido, String email, String address, String encodedPassword, String categoria1, String categoria2, String categoria3, String role) {
    	this.name = name;
    	this.surname = apellido;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.address = address;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
        this.categoria3 = categoria3;
		this.roles.add("USER");
		this.roles.add(role);
    }


	//Setters y Getters

	public Long getId() {
		return this.id;
	}

    public String getName() {
        return this.name;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public String getSurname() { return this.surname; }
    
    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

	@JsonIgnore
    public String getEncodedPassword() {
		return this.encodedPassword;
	}
    
    public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

    public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}

	public String getCategoria1() {
		return this.categoria1;
	}

	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}

	public String getCategoria2() {
		return this.categoria2;
	}

	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}

	public String getCategoria3() {
		return this.categoria3;
	}

	public void setCategoria3(String categoria3) {
		this.categoria3 = categoria3;
	}

	public void addCounteroffer(Counteroffer newCounteroffer) { this.counterofferList.add(newCounteroffer); }

	public void addProduct(Product newProduct) { this.productList.add(newProduct); }

	public void addTransaction(Transaction newTransaction) { this.transactionList.add(newTransaction); }

	//Others

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
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", address="
				+ address + ", encodedPassword=" + encodedPassword
				+ ", imageFile=" + imageFile + "]";
	}
}


