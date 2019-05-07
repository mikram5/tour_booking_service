package com.mike.tour_booking_service.data;

import com.mike.tour_booking_service.logic.CustomerAddressRepository;
import com.mike.tour_booking_service.logic.CustomerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

//public class MySqlCustomerAddressRepository implements CustomerAddressRepository {
//
//    private static final String TABLE_NAME = "customer_address";
//    private static final String ALL_FIELDS = "*";
//    private final CustomerRowMapper rowMapper = new CustomerRowMapper();
//
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    MySqlCustomerAddressRepository(NamedParameterJdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public CustomerAddress save(CustomerAddress customerAddress) {
//        String query = "INSERT INTO " + TABLE_NAME +
//                " VALUES(null, :streetAddress, :apartmentNo, :state, :zip )";
//        KeyHolder key = new GeneratedKeyHolder();
//        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(customerAddress);
//        jdbcTemplate.update(query, namedParameters, key);
//        customerAddress.setId(key.getKey().intValue());
//        return customerAddress;
//    }




//}
