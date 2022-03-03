package pl.kowalecki.bnpapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "Komputery")
@XmlType(propOrder = {"name", "dateAccounting", "priceUSD", "pricePLN"})
@Entity
@Table(name = "computer")
public class ComputersModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @XmlElement(name = "nazwa")
    @Column(name = "name")
    private String name;
    @XmlElement(name = "data_ksiegowania")
    @Column(name = "date_accounting")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateAccounting;
    @XmlElement(name = "koszt_USD")
    @Column(name = "price_USD")
    private BigDecimal priceUSD;
    @XmlElement(name = "koszt_PLN")
    @Column(name = "price_PLN")
    private BigDecimal pricePLN;

    public ComputersModel(int id, String name, String dateAccounting, BigDecimal priceUSD, BigDecimal pricePLN) {
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

    public String getDateAccounting() {
        return dateAccounting;
    }

    public void setDateAccounting(String dateAccounting) {
        this.dateAccounting = dateAccounting;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    public BigDecimal getPricePLN() {
        return pricePLN;
    }

    public void setPricePLN(BigDecimal pricePLN) {
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