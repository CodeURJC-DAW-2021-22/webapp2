package es.codeurjc.Flyventas.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;
    private float price;

    @OneToOne
    @JsonProperty("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonProperty("buyer_id")
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @JsonProperty("seller_id")
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;


    //Constructores

    public Transaction() {}

    public Transaction(Product product, User buyer, float price) {
        super();
        this.date = getActualDate();
        this.price = price;
        this.product = product;
        this.product.setIsSold(true);
        this.buyer = buyer;
        this.buyer.addTransaction(this);
        this.seller = product.getUser();
        if(!(this.seller == null)) {
            this.seller.addTransaction(this);
        }
    }


    //Setters y Getters

    public Long getId() { return this.id; }

    public String getDate() { return this.date; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }


    //Others

    private String getActualDate() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(date);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", date=" + date + ", price=" + price + ", product=" + product + ", seller=" + seller + ", buyer=" + buyer + "]";
    }

}
