package com.mike.tour_booking_service.data;

import com.mike.tour_booking_service.logic.Customer;
import com.mike.tour_booking_service.logic.Tour;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

        Customer customer = new Customer();
        customer.setId(rs.getInt("c_id"));
        customer.setLastName(rs.getString("c_last_name"));
        customer.setFirstName(rs.getString("c_first_name"));

        return customer;
    }

}

