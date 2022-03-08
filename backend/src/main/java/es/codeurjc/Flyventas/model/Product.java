package es.codeurjc.Flyventas.model;

import javax.persistence.*;

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
    @Lob
	//private Blob imageFile;

	//private boolean image;

    /*@ManyToOne
    private User user; */
    //de momento lo comento para poder crear productos de ejemplo sin insertar un usuario
    private String user;

    //public Product(String name, String description, String category, float price, boolean isSold) {}

    public Product() {}


    public Product(String title, String description, String category, float price, boolean isSold) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = isSold;
    }


    public Long getId() { return this.id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category +  ", price="
                + price + ", isSold=" + isSold;
    }


//    public String getUser() {
//        return user;
//    }
//    public Blob getImageFile() {
//		return imageFile;
//	}
//
//	public void setImageFile(Blob image) {
//		this.imageFile = image;
//	}
//
//	public boolean getImage(){
//		return this.image;
//	}
//
//	public void setImage(boolean image){
//		this.image = image;
//	}
}


