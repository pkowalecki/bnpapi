package pl.kowalecki.bnpapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "computer")
public class ComputersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_accounting")
    private Date dateAccounting;
    @Column(name = "price_USD")
    private float priceUSD;
    @Column(name = "price_PLN")
    private float pricePLN;

    public ComputersModel(int id, String name, Date dateAccounting, float priceUSD, float pricePLN) {
        this.id = id;
        this.name = name;
        this.dateAccounting = dateAccounting;
        this.priceUSD = priceUSD;
        this.pricePLN = pricePLN;
    }

    public ComputersModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAccounting() {
        return dateAccounting;
    }

    public void setDateAccounting(Date dateAccounting) {
        this.dateAccounting = dateAccounting;
    }

    public float getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(float priceUSD) {
        this.priceUSD = priceUSD;
    }

    public float getPricePLN() {
        return pricePLN;
    }

    public void setPricePLN(float pricePLN) {
        this.pricePLN = pricePLN;
    }

    @Override
    public String toString() {
        return "ComputersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateAccounting=" + dateAccounting +
                ", priceUSD=" + priceUSD +
                ", pricePLN=" + pricePLN +
                '}';
    }
}