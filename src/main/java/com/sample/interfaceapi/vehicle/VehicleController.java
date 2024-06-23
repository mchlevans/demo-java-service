package com.autos.api.vehicle;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.autos.api.common.SuccessResponse;

import java.sql.SQLException;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    // get vehicle by id
    @GetMapping("/vehicle/variables")
    public SuccessResponse<VehicleVariable[]> vehicleVariable() {
        SuccessResponse response = new SuccessResponse();
        response.setStatus("200");
        response.setData(vehicleService.getVariables());
        return response;
    }

    // get vehicle by id
    @GetMapping("/vehicle/{id}")
    public SuccessResponse<Vehicle> vehicle(@PathVariable Integer id) {
        SuccessResponse response = new SuccessResponse();
        response.setStatus("200");
        response.setData(vehicleService.getVehicleById(id));
        return response;
    }

    // get top n vehicle records
    @GetMapping(value = "/vehicle", params = { "limit", "offset" })
    public SuccessResponse<List<Vehicle>> vehicle(@RequestParam Integer limit, @RequestParam Integer offset) {
        SuccessResponse response = new SuccessResponse();
        response.setStatus("200");
        response.setData(vehicleService.getVehiclesPaginated(limit, offset));
        return response;
    }

    // alternative endpont for vehicle data using streams
    // @GetMapping(value = "/vehicle-stream")
    // public Stream<Vehicle> vehicle() {
    //     try {
    //         return vehicleService.getVehiclesStream();
    //     } catch (SQLException e) {
    //         return null;
    //     }
    // }
}
