package com.mike.tour_booking_service.data;

import com.mike.tour_booking_service.logic.Customer;
import com.mike.tour_booking_service.logic.CustomerRepository;
import com.mike.tour_booking_service.data.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class MySqlCustomerRepository implements CustomerRepository {

    private static final String TABLE_NAME = "customers";
    private static final String ALL_FIELDS = "*";
    private final CustomerRowMapper rowMapper = new CustomerRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    MySqlCustomerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Customer save(Customer customer) {
        String query = "INSERT INTO " + TABLE_NAME +
                " VALUES(null, :lastName, :firstName )";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(customer);
        jdbcTemplate.update(query, namedParameters, key);
        customer.setId(key.getKey().intValue());
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME;
        return jdbcTemplate.query(query, rowMapper);
    }

    public Customer getByLastName(String lastName) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " c_last_name = :lastName";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("last_name", lastName);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    public Customer getById(Integer id) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " c_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

}
