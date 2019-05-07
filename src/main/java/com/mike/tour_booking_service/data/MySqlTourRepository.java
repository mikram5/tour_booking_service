package com.mike.tour_booking_service.data;

import com.mike.tour_booking_service.logic.Tour;
import com.mike.tour_booking_service.logic.TourRepository;
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
public class MySqlTourRepository implements TourRepository {

    private static final String TABLE_NAME = "tours";
    private static final String ALL_FIELDS = "*";
    private final TourRowMapper rowMapper = new TourRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    MySqlTourRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Tour save(Tour tour) {
        String query = "INSERT INTO " + TABLE_NAME +
                " VALUES(null, :description, :price )";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(tour);
        jdbcTemplate.update(query, namedParameters, key);
        tour.setId(key.getKey().intValue());
        return tour;
    }

    @Override
    public List<Tour> getTours() {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME;
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Tour getById(Integer id) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public  Tour getByDescription(String description) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " t_description = :description ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("description", description);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public void deleteById(Integer id) {
        String query = "DELETE " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " t_id = :id ";
    }

}
