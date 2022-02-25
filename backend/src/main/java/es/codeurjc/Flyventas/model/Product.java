package es.codeurjc.Flyventas.model;

import javax.persistence.*;

@Entity
@Table(name="id_products")
public class Product {

    @Id
    private long id;

    private String title;
    private String description;
    private String category;
    private int price;
    private boolean isSold;

    /*@ManyToOne
    private User user; */
    //de momento lo comento para poder crear productos de ejemplo sin insertar un usuario
    private String user;

    public void setProduct(Long id, String title, String description, String category, int price, String user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = false;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean sold) {
        this.isSold = sold;
    }

    public String getUser() {
        return user;
    }
}


