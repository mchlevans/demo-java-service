package com.autos.api.vehicle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(VehicleController.class)
class VehicleControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleService vehicleService;

	static Vehicle mockVehicleResponse;
	private final Integer vehicleId = 17503;

	@Test
	void shouldReturnVehicleWithId() throws Exception {
		when(vehicleService.getVehicleById(vehicleId)).thenReturn(mockVehicleResponse);
		MvcResult result = this.mockMvc.perform(get("/vehicle/{id}", vehicleId))
			.andExpect(status().isOk())
			.andReturn();
	}
}
