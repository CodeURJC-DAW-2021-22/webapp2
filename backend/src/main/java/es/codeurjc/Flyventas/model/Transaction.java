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

    //@OneToOne(cascade = CascadeType.ALL)
    private String product;

    /*@ManyToOne
    private User buyer;

    @ManyToOne
    private User seller;*/

    //Constructores

    public Transaction() {}

    public Transaction(String product) {
        super();
        this.date = getActualDate();
        this.product = product;
        /*this.buyer = buyer;
        this.seller = seller;
        this.product.setIsSold(true);*/
    }

    //Setters y Getters

    public Long getId() { return this.id; }

    public String getDate() { return this.getDate(); }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    //Others

    private String getActualDate() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", date=" + date + ", price=" + price + ", product=" + product + "]";
    }

}
