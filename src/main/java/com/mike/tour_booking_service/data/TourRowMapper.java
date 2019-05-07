package com.mike.tour_booking_service.data;

import com.mike.tour_booking_service.logic.Tour;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourRowMapper implements RowMapper<Tour> {

    @Override
    public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {

        Tour tour = new Tour();
        tour.setId(rs.getInt("t_id"));
        tour.setDescription(rs.getString("t_description"));
        tour.setPrice(rs.getDouble("t_price"));

        return tour;
    }
}
