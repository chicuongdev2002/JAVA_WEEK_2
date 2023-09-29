package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name="order_id",columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;
    @Column(name="order_date",columnDefinition = "datetime(6)")
    private LocalDateTime orderDate;
    @ManyToOne()
    @JoinColumn(name="cus_id",referencedColumnName = "cust_id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name="employee_id",referencedColumnName = "emp_id",nullable = false)
    private Employee employee;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
