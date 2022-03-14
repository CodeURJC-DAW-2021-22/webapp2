package es.codeurjc.Flyventas.model;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Counteroffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float newPrice;
    private String date;

    @OneToOne
    private Product product;

    @ManyToOne
    private User transmitter;

    @ManyToOne
    private User receiver;


    //Constructores

    public Counteroffer() {}

    public Counteroffer(Product product, float newPrice, User transmitter) {
        super();
        this.product = product;
        this.newPrice = newPrice;
        this.date = getActualDate();
        this.transmitter = transmitter;
        this.receiver = product.getUser();
        if(!(this.receiver == null)) {
            this.receiver.addCounteroffer(this);
        }
    }


    //Setters y Getters

    public Long getId() { return this.id; }

    public String getDate() { return this.date; }

    public float getNewPrice() { return this.newPrice; }

    public void setPrice(float newPrice) { this.newPrice = newPrice; }

    public User getReceiver() { return this.receiver; }

    public Product getProduct() { return this.product; }

    public User getTransmitter() { return this.transmitter; }


    //Others

    @Override
    public String toString() {
        return "User [id=" + id + ", newPrice=" + newPrice + ", product=" + product + ", buyer=" + transmitter + "]";
    }

    private String getActualDate() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(date);
    }

}
