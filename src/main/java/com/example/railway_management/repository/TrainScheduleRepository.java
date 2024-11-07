package com.example.railway_management.repository;

import com.example.railway_management.model.TrainSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TrainScheduleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<TrainSchedule> rowMapper = new RowMapper<TrainSchedule>() {
        @Override
        public TrainSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
            TrainSchedule schedule = new TrainSchedule();
            schedule.setStationId(rs.getInt("station_id"));
            schedule.setTrainId(rs.getInt("train_id")); 

            // Set dayOfWeek as String
            String dayOfWeek = rs.getString("day"); // Updated column name
            schedule.setDayOfWeek(dayOfWeek);
            
            // Map arrival and departure as LocalDateTime
            schedule.setArrival(rs.getTimestamp("arrival").toLocalDateTime());
            schedule.setDeparture(rs.getTimestamp("departure").toLocalDateTime());
            schedule.setPlatformNumber(rs.getString("platform_number"));
            return schedule;
        }
    };

    public List<TrainSchedule> findByFromAndTo(int from, int to, String dayOfWeek) {
        System.out.println("Finding train schedules from " + from + " to " + to + " on " + dayOfWeek);

        int fromStationId = from;
        int toStationId = to;

        String sql = "SELECT DISTINCT ts1.train_id, ts1.station_id, ts1.day, ts1.arrival, " +
                     "ts1.departure, ts1.platform_number " +
                     "FROM train_schedule ts1 " +
                     "JOIN train_schedule ts2 ON ts1.train_id = ts2.train_id " +
                     "WHERE ts1.station_id = ? " +
                     "AND ts2.station_id = ? " +
                     "AND ts1.day = ? " +
                     "AND ts2.day = ? " +
                     "AND ts1.arrival <= ts2.arrival";

        return jdbcTemplate.query(sql, new Object[]{fromStationId, toStationId, dayOfWeek, dayOfWeek}, rowMapper);
    }

    public List<TrainSchedule> findAll() {
        String sql = "SELECT * FROM train_schedule";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<TrainSchedule> findByStationAndTrainId(int from, int trainId) {
        String sql = "SELECT * FROM train_schedule WHERE station_id = ? AND train_id = ?";
        return jdbcTemplate.query(sql, new Object[]{from, trainId}, rowMapper);
    }

    public LocalDateTime getArrivalTime(int trainId, int stationId, String date) {
        String sql = "SELECT arrival FROM train_schedule " +
                     "WHERE train_id = ? AND station_id = ? AND day = ?";

        String dayOfWeek = getDayOfWeekFromDate(date);
        return jdbcTemplate.queryForObject(sql, new Object[]{trainId, stationId, dayOfWeek}, LocalDateTime.class);
    }

    private String getDayOfWeekFromDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfWeek().name(); // Returns the day of the week in uppercase
    }
}
