package com.example.railway_management.repository;

import com.example.railway_management.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class TrainRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Train> rowMapper = new RowMapper<Train>() {
        @Override
        public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
            Train train = new Train();
            train.setTrainId(rs.getInt("TRAIN_ID"));
            train.setTrainName(rs.getString("TRAIN_NAME"));
            // Map enum from the database to the TrainType enum
            train.setStatus(rs.getString("STATUS")); // Map status field
            return train;
        }
    };

    public Optional<Train> findById(int id) {
        String sql = "SELECT * FROM TRAIN WHERE TRAIN_ID = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, rowMapper).stream().findFirst();
    }

    public List<Train> findAll() {
        String sql = "SELECT * FROM TRAIN";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public String getTrainTypeById(int trainId) {
        String sql = "SELECT TRAIN_TYPE FROM TRAIN WHERE TRAIN_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{trainId}, String.class);
    }

    // Add methods for saving/updating/deleting trains if needed
}
