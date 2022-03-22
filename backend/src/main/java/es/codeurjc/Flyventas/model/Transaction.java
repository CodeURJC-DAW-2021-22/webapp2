package es.codeurjc.Flyventas.model;
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
    private Product product;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private User buyer;

    @ManyToOne
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
