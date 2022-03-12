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

    /*@Lob
	private Blob imageFile;*/

	//private boolean image;

    @ManyToOne
    private User user;


    //Constructores

    public Product() {}

    public Product(String title, String description, String category, float price, boolean isSold, User user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isSold = isSold;
        this.user = user;
        if(!(this.user == null)) {
            this.user.addProduct(this);
        }
    }


    //Setters y Getters

    public Long getId() { return this.id; }

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    public void setCategory(String category) { this.category = category; }

    public String getCategory() { return this.category; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public float getPrice() { return this.price; }

    public void setPrice(float price) { this.price = price; }

    public boolean getIsSold() { return this.isSold; }

    public void setIsSold(boolean isSold) { this.isSold = isSold; }

    public User getUser() { return this.user; }


    //Others

    @Override
    public String toString() {
        return "User [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category +  ", price="
                + price + ", isSold=" + isSold;
    }





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


