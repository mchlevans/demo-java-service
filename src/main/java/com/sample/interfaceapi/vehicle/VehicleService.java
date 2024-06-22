package com.autos.api.vehicle;

// import com.autos.api.db.DataSourceLimited;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ConnectionBuilder;
import javax.sql.DataSource;
import java.io.PrintWriter;

@Component
public class VehicleService {

    @Autowired
	JdbcTemplate jdbcTemplate;

    // Vehicle attribute lists could be moved to a db table, simplifying a bit by keeping in memory (also reduces latency)
    private final String[] dbVariableNames = { "price", "engine_size", "peak_rpm", "highway_mpg", "horsepower", "diesel", "gas" };
    private final String[] displayVariableNames = { "Price", "Engine Size", "Peak Rpm", "Highway Mpg", "Horsepower", "Diesel (dummy)", "Gas (dummy)" };
    private final String[] compressedNames = { "price", "engineSize", "peakRpm", "highwayMpg", "horsepower", "diesel", "gas" };

    // fetch select variable names related to a vehicle
    public VehicleVariable[] getVariables() {
        VehicleVariable[] variables = new VehicleVariable[compressedNames.length];
        for (int i = 0; i < compressedNames.length; i++) {
            VehicleVariable variable = new VehicleVariable();
            variable.setDisplayName(displayVariableNames[i]);
            variable.setCompressedName(compressedNames[i]);
            variables[i] = variable;
        }

        return variables;
    }

    // fetch vehicle record with id and return it
    public Vehicle getVehicleById(Integer id) {
        String query = "SELECT * FROM vehicle WHERE vehicle_id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Vehicle.class), id);
    }

    // fetch top N vehicle records
    public List<Vehicle> getVehiclesPaginated(Integer limit, Integer offset) {
        String query = "SELECT * FROM vehicle LIMIT ? OFFSET ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Vehicle.class), limit, offset);
    }

    // get vehicle records stream
    // public Stream<Vehicle> getVehiclesStream() throws SQLException {
    //     String query = "SELECT * FROM vehicle";

    //     DataSource datasource = jdbcTemplate.getDataSource();
    //     jdbcTemplate.setDataSource(new DataSourceLimited(datasource));
        
    //     jdbcTemplate.setFetchSize(10000);
    //     Stream<Vehicle> result = jdbcTemplate.queryForStream(query, new BeanPropertyRowMapper<>(Vehicle.class));
    //     jdbcTemplate.getDataSource().getConnection().commit();
        
    //     return result;
    // }
}
