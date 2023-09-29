package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.converter.EmployeeStatusConverter;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.EmployeeStatus;


import java.time.LocalDateTime;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",unique = true, nullable = false,columnDefinition = "BIGINT(20)")
    private Long empId;

    @Column(name = "full_name", columnDefinition = "varchar(255)",nullable = false)
    private String fullName;

    @Column(name = "dob", columnDefinition = "datetime(6)",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;

    @Column(name = "email", columnDefinition = "varchar(150)",nullable = true)
    private String email;

    @Column(name = "phone", columnDefinition = "varchar(15)",nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "varchar(250)",nullable = false)
    private String address;

    @Column(name = "status",nullable = false,columnDefinition = "int(11)")
    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;
//    @OneToMany(mappedBy = "employee")
//    private List<Order> orderList;
    public Employee() {
    }

    public Employee(Long empId) {
        this.empId = empId;
    }

    public Employee(Long empId, String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.empId = empId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status=status;
    }

    public Employee(String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
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

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

}
