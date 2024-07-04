package com.autos.api.model;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.jayway.jsonpath.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ModelController.class)
public class ModelControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelService modelService;

    private String modelPath = "/model";

    @Test
    public void shouldRespondWithMissingFields() throws Exception {
        String modelRequestBody = "{}";
        MediaType contentType = MediaType.APPLICATION_JSON;
        int numberOfRequiredFields = 3; // should match number of errors

        MvcResult result = mockMvc.perform(post(modelPath)
            .content(modelRequestBody)
            .contentType(contentType))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andReturn();
        
        // check response body
        String response = result.getResponse().getContentAsString();
        List<String> errors = JsonPath.parse(response).read("$.errors");
        Assertions.assertEquals(numberOfRequiredFields, errors.size());
    }
}
