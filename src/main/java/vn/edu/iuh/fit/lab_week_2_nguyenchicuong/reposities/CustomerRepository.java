package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.reposities;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.models.Customer;

public class CustomerRepository extends CRUDRepository<Customer, Long> {

    public CustomerRepository(Class<Customer> enityClass) {
        super(enityClass);
    }
}
