package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id",unique = true,nullable = false)
    private long image_id;
    @Column(name = "alternative",columnDefinition = "VARCHAR(250)")
    private String alternative;
    @Column(name = "path",columnDefinition = "VARCHAR(250)")
    private String path;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",referencedColumnName = "product_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

}
