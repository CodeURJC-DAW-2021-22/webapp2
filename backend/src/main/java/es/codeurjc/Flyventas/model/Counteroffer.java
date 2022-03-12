package es.codeurjc.Flyventas.model;
import javax.persistence.*;

@Entity
public class Counteroffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float newPrice;

    @OneToOne
    private Product product;

    @ManyToOne
    private User transmitter;

    @ManyToOne
    private User receiver;


    //Constructores

    public Counteroffer() {}

    public Counteroffer(Product product, float newPrice, User buyer) {
        super();
        this.product = product;
        this.newPrice = newPrice;
        this.transmitter = buyer;
        this.receiver = product.getUser();
        if(!(this.receiver == null)) {
            this.receiver.addCounteroffer(this);
        }
    }


    //Setters y Getters

    public Long getId() { return this.id; }

    public String getDate() { return this.getDate(); }

    public float getNewPrice() { return this.newPrice; }

    public void setPrice(float newPrice) { this.newPrice = newPrice; }

    public User getReceiver() { return this.receiver; }


    //Others

    @Override
    public String toString() {
        return "User [id=" + id + ", newPrice=" + newPrice + ", product=" + product + ", buyer=" + transmitter + "]";
    }

}
