package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice implements Serializable {

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
}
