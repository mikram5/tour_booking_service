package com.mike.tour_booking_service.logic;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository {

    Tour save(Tour tour);

    List<Tour> getTours();

    Tour getById(Integer id);

    Tour getByDescription(String description);

    void deleteById(Integer id);

}
