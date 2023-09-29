package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", unique = true, nullable = false,columnDefinition = "BIGINT(20)")
    private Long id;

    @Column(name = "cust_name", columnDefinition = "varchar(150)",nullable = false)
    private String custName;

    @Column(name = "email", columnDefinition = "varchar(150)",nullable = true)
    private String email;

    @Column(name = "phone", columnDefinition = "varchar(15)",nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "varchar(150)",nullable = false)
    private String address;
//    @OneToMany(mappedBy = "customer ",fetch = FetchType.LAZY)
//    private List<Order> listO;
    public Customer() {
    }

    public Customer(Long custId) {
        this.id = custId;
    }

    public Customer(Long custId, String custName, String email, String phone, String address) {
        this.id = custId;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String custName, String email, String phone, String address) {
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
// Getters and setters

    public Long getCustId() {
        return id;
    }

    public void setCustId(Long custId) {
        this.id = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
