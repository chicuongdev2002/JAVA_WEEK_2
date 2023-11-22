package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice implements Serializable {
    @Id
    @Column(name = "price_date_time", unique = true, nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime price_date_time;
    @Column(name = "note",columnDefinition = "varchar(255)")
    private String note;
    @Column(name = "price",columnDefinition = "double")
    private double price;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime price_date_time, String note, double price) {
        this.price_date_time = price_date_time;
        this.note = note;
        this.price = price;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price_date_time=" + price_date_time +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }
}
