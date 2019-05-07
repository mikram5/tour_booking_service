package com.mike.tour_booking_service.logic;

import org.springframework.stereotype.Repository;
import com.mike.tour_booking_service.logic.Customer;

import java.util.List;

@Repository
public interface CustomerRepository {

    Customer save(Customer customer);

    List<Customer> getCustomers();

    Customer getById(Integer id);

    Customer getByLastName(String lastName);
}
