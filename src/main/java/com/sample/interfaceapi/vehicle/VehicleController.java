package com.autos.api.vehicle;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    // get vehicle by id
    @GetMapping("/vehicle/{id}")
    public Vehicle vehicle(@PathVariable Integer id) {
        return vehicleService.getVehicleById(id);
    }

    // get top n vehicle records
    @GetMapping(value = "/vehicle", params = { "limit", "offset" })
    public List<Vehicle> vehicle(@RequestParam Integer limit, @RequestParam Integer offset) {
        return vehicleService.getVehiclesPaginated(limit, offset);
    }

    // alternative endpont for vehicle data using streams
    @GetMapping(value = "/vehicle-stream")
    public Stream<Vehicle> vehicle() {
        try {
            return vehicleService.getVehiclesStream();
        } catch (SQLException e) {
            return null;
        }
    }
}
