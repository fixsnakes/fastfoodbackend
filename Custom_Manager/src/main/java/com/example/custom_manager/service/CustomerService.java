package com.example.custom_manager.service;


import com.example.custom_manager.model.Customer;
import com.example.custom_manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    //findCustomer

    public Optional<Customer> findCustomer(Customer customer ) {
        return customerRepository.findCustomerByPhone(customer.getPhone());
    }

    //authenticate
    public Customer authenticateUser(String phone, String password) {
        Optional<Customer> customerfind = customerRepository.findCustomerByPhone(phone);
        if (customerfind.isPresent()) {
            if (customerfind.get().getPassword().equals(password)) {
                return customerfind.get();
            }
        }

        return null;
    }



    //getlisthCustommer
    public List<Customer> getlistCustomer() {
        return customerRepository.findAll();
    }

    //addCustomer
    public boolean addCustomer(Customer customerAdd) {
        customerRepository.save(customerAdd);
        return true;
    }

    //updatecustomer
    public boolean updateCustomer(Customer customerUpdate) {
        Optional<Customer> customerFind = customerRepository.findById(customerUpdate.getCustomer_id());
        if (customerFind.isPresent()) {
            Customer customer = customerFind.get();
            customer.setFullname(customerUpdate.getFullname());
            customer.setEmail(customerUpdate.getEmail());
            customer.setPhone(customerUpdate.getPhone());
            customer.setAddress(customerUpdate.getAddress());
            customer.setPassword(customerUpdate.getPassword());
            customerRepository.save(customer);

            return true;
        }
        return false;
    }

    //deletecustomer
    public boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //findcustomerid
    public boolean findCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return true;
        }
        return false;
    }
}
