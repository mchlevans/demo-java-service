package com.autos.api.vehicle;

import java.util.Date;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// NoArgsConstuctor required for automatic mapping
@Getter @Setter @NoArgsConstructor
public class Vehicle {
    private String aspiration;
    private String bodyStyle;
    private Float bore;
    private Float cityL100km;
    private Float cityMpg;
    private Float compressionRatio;
    private Float curbWeight;
    private Boolean diesel;
    private String driveWheels;
    private String engineLocation;
    private Float engineSize;
    private String engineType;
    private String fuelSystem;
    private Boolean gas;
    private Float height;
    private Float highwayMpg;
    private Float horsepower;
    private String horsepowerBinned;
    private Float length;
    private String make;
    private Float normalizedLosses;
    private String numOfCylinders;
    private String numOfDoors;
    private Float peakRpm;
    private Float price;
    private Float stroke;
    private Float symboling;
    private Integer vehicle_id;
    private Float wheelBase;
    private Float width;
}
