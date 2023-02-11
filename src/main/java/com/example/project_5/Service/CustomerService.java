package com.example.project_5.Service;


import com.example.project_5.Exception.ApiException;
import com.example.project_5.Model.Customer;
import com.example.project_5.Model.Store;
import com.example.project_5.Repository.CustomerRepository;
import com.example.project_5.Repository.StoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private StoreRepository storeRepository;

    public CustomerService (CustomerRepository customerRepository,StoreRepository storeRepository){
        this.customerRepository=customerRepository;
        this.storeRepository=storeRepository;
    }

    public List<Customer> GetAll(){
        return customerRepository.findAll();
    }

    public void AddCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void UpdateCustomer(Integer id ,Customer customer){
        Customer old_customer = customerRepository.findCustomersById(id);
        if(old_customer==null){
            throw new ApiException("customer id not found!!");
        }
        old_customer.setName(customer.getName());
        old_customer.setPhoneNumber(customer.getPhoneNumber());
        old_customer.setEmail(customer.getEmail());
        customerRepository.save(old_customer);
    }
    public void DeleteCustomer(Integer id){
        Customer delete_customer= customerRepository.findCustomersById(id);
        if(delete_customer==null){
            throw new ApiException("customer id not found!!");
        }
        customerRepository.delete(delete_customer);
    }

    public void AssignCustomerToStore(Integer customer_id,Integer store_id){
        Customer customer= customerRepository.findCustomersById(customer_id);
        Store store = storeRepository.findStoreById(store_id);
        if(customer==null ||  store==null){
            throw  new ApiException("customer id or store id not found");
        }
        customer.getStores().add(store);
        customerRepository.save(customer);
        store.getCustomers().add(customer);
        storeRepository.save(store);
    }

    //takes storeid and return all customers
    public List<Customer> ReturnAllCustomer(Integer store_id){
        Store store= storeRepository.findStoreById(store_id);
        if(store==null){
            throw new ApiException("store id not found");
        }
        else if(store.getCustomers().isEmpty()){
            throw new ApiException("no customers.");

        }
        return store.getCustomers();
    }
}
