package com.example.project_5.Repository;


import com.example.project_5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomersById(Integer id);

    Customer findCustomersByStoresId(Integer id);

}
