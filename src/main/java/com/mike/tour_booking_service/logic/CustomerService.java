package com.mike.tour_booking_service.logic;

import com.mike.tour_booking_service.logic.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer save(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer getById(Integer id) {
        return customerRepository.getById(id);
    }

    public Customer getByLastName(String lastName) {
        return customerRepository.getByLastName(lastName);
    }


}
