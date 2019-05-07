package com.mike.tour_booking_service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TourService {

    @Resource
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getTours() {
        return tourRepository.getTours();
    }

    public Tour save(Tour tour) {
        Tour savedTour = tourRepository.save(tour);
        return savedTour;
    }

    public Tour getById(Integer id) {
        return tourRepository.getById(id);
    }

    public Tour getByDescription(String description) {
        return tourRepository.getByDescription(description);
    }

    public void deleteById(Integer id) {
        tourRepository.deleteById(id);
    }

}
