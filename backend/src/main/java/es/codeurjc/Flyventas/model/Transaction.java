package es.codeurjc.Flyventas.model;

import javax.persistence.*;

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

    public Transaction(long id) {
        super();
        this.id = id;
    }

    //Setters y Getters


}
