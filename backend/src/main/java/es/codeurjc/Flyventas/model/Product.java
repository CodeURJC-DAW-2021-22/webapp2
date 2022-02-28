package es.codeurjc.Flyventas.model;

import javax.persistence.*;

import java.sql.Blob;

@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private float price;
    @Column
    private boolean isSold;
    @Lob
    private Blob imageFile;

    private boolean image; //Ni idea de qué es este booleano xd, pero seguro que me la agarra con la mano

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "product")
    private Transaction transaction;

    //Constructores

    public Product() {}

    public Product(long id, String title, String description, String category, float price) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = false;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", titulo=" + title + ", descripción=" + description + ", categoría=" + category + ", precio="
                + price + ", isSold=" + isSold + "]";
    }

    //Setters y Getters

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public boolean getIsSold() { return isSold; }

    public void setIsSold(boolean sold) { this.isSold = sold; }

    public Blob getImageFile() { return imageFile; }

    public void setImageFile(Blob image) { this.imageFile = image; }

    public boolean getImage(){ return this.image; }

    public void setImage(boolean image){ this.image = image; }

}


