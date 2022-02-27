package es.codeurjc.Flyventas.model;

import javax.persistence.*;

import java.sql.Blob;

@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    private String title;
    private String description;
    private String category;
    private int price;
    private boolean isSold;
    @Lob
	private Blob imageFile;

	private boolean image;

    /*@ManyToOne
    private User user; */
    //de momento lo comento para poder crear productos de ejemplo sin insertar un usuario
    private String user;

    public Product() {}

    public Product(int id, String title, String description, String category, int price, String user) {
    	this.id = (long) id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = false;
        this.user = user;
    }

    public long getId() {
        return id;
    }

	public void setId(long id) {
		this.id = id;
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
    public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}

	public boolean getImage(){
		return this.image;
	}

	public void setImage(boolean image){
		this.image = image;
	}
}


