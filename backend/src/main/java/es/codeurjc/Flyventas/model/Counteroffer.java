package es.codeurjc.Flyventas.model;
import javax.persistence.*;

@Entity

public class Counteroffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private boolean isAccepted;

    @ManyToOne
    private Product product;

    //Constructores

    public Counteroffer() {}

    public Counteroffer(long id, Product product) {
        super();
        this.id = id;
        this.isAccepted = false;
        this.product = product;
    }

    //Setters y Getters

    public long getId() { return this.id; }

    public void setId(long id) { this.id = id; }

    public boolean getIsAccepted() { return this.isAccepted; }

    public void setIsAccepted() { this.isAccepted = true; }

    //Others


}
