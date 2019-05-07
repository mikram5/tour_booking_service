package com.mike.tour_booking_service.logic;

public interface CustomerAddressRepository {

    CustomerAddress save(CustomerAddress customerAddress);

    CustomerAddress getByStreetAddress(String streetAddress);

    CustomerAddress getByZip(String zip);

    void deleteById(Integer id);


}
