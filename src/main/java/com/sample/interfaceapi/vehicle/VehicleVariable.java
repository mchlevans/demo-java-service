package com.autos.api.vehicle;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// NoArgsConstuctor required for automatic mapping
@Getter @Setter @NoArgsConstructor
public class VehicleVariable {
    private String displayName;
    private String compressedName;
}
