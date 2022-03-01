package es.codeurjc.Flyventas.model;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String date;
    @Column
    private float price;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private User seller;

    //Constructores

    public Transaction() {}

    public Transaction(long id, Product product) {
        super();
        this.id = id;
        this.date = getActualDate();
        this.product = product;
        this.product.setIsSold(true);

    }

    //Setters y Getters

    public long getId() { return this.id; }

    public void setId(long id) { this.id = id; }

    public String getDate() { return this.date; }

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }


    //Others

    public String getActualDate() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

}
