package com.example.railway_management.repository;

import com.example.railway_management.model.TrainSchedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrainEnquiryRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrainEnquiryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Method to find train schedules sorted by day and arrival time.
     *
     * @param trainId The ID of the train to look up schedules for.
     * @return A list of TrainSchedule objects corresponding to the train ID.
     */
    public List<TrainSchedule> findTrainScheduleById(int trainId) {
        String sql = "SELECT * FROM train_schedule WHERE train_id = ? ORDER BY day, arrival";

        return jdbcTemplate.query(sql, new Object[]{trainId}, new RowMapper<TrainSchedule>() {
            @Override
            public TrainSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                TrainSchedule schedule = new TrainSchedule();
                schedule.setTrainId(rs.getInt("train_id"));
                schedule.setStationId(rs.getInt("station_id"));
                schedule.setDayOfWeek(rs.getString("day"));
                
                // Use `toLocalDateTime` for DATETIME columns
                schedule.setArrival(rs.getTimestamp("arrival").toLocalDateTime());
                schedule.setDeparture(rs.getTimestamp("departure").toLocalDateTime());
                schedule.setPlatformNumber(rs.getString("platform_number"));

                return schedule;
            }
        });
    }
}
