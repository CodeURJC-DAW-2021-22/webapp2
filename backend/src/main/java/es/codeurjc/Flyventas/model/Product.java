package es.codeurjc.Flyventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    private String title;
    private String description;
    private String category;
    private float price;
    private boolean isSold;
    private Boolean image;

    @Lob
    @JsonIgnore
    private Blob imageFile;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
    private List<Counteroffer> counterofferList = new ArrayList<>();

    @OneToMany(mappedBy = "transmitter", cascade = CascadeType.REMOVE)
    private List<Counteroffer> counterofferList1 = new ArrayList<>();

    @OneToMany(mappedBy = "seller", cascade = CascadeType.REMOVE)
    private List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE)
    private List<Transaction> transactionList1 = new ArrayList<>();




    //Constructores

    public Product() {
    }

    public Product(String title, String description, String category, float price, boolean isSold, User user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = isSold;
        this.user = user;
        if (!(this.user == null)) {
            this.user.addProduct(this);
        }
    }


    //Setters y Getters

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getIsSold() {
        return this.isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public User getUser() {
        return this.user;
    }

    public void setImageFile(Blob imageFile) {
        this.imageFile = imageFile;
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    public Boolean getImage() {
        return this.image;
    }


    //Others

    @Override
    public String toString() {
        return "User [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category + ", price="
                + price + ", isSold=" + isSold;
    }
}