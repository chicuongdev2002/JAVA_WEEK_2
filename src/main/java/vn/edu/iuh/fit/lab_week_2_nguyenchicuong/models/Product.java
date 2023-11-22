package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.converter.ProductStatusConverter;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.ProductStatus;


import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "product")
public class Product implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id",unique = true,nullable = false)
    private long product_id;
    @Column(name = "description",columnDefinition = "nvarchar(250)")
    private String description;
    @Column(name = "manufactuner_name",columnDefinition = "nvarchar(100)")
    private String manufactuner;
    @Column(name = "name",columnDefinition = "nvarchar(150)")
    private String name;

    @Column(name = "status",columnDefinition = "int(11)")
    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;
    @Column(name = "unit",columnDefinition = "nvarchar(25)")
    private String unit;
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<ProductImage> images;
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    private List<OrderDetail> orderDetails;


    public Product(String description, String manufactuner, String name, ProductStatus status, String unit) {
        this.description = description;
        this.manufactuner = manufactuner;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }

    public Product() {
    }

    public Product(long product_id) {
        this.product_id = product_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactuner() {
        return manufactuner;
    }

    public void setManufactuner(String manufactuner) {
        this.manufactuner = manufactuner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", description='" + description + '\'' +
                ", manufactuner='" + manufactuner + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                '}';
    }
}
