package com.ecommerce.userservice.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("GlobalExceptionHandler Tests")
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should handle ResourceNotFoundException with 404 status")
    void testResourceNotFoundExceptionHandling() throws Exception {
        mockMvc.perform(get("/api/v1/admin/users/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Resource Not Found"));
    }

    @Test
    @DisplayName("Should include error details in response")
    void testExceptionResponseStructure() throws Exception {
        mockMvc.perform(get("/api/v1/admin/users/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.path").exists());
    }

    @Test
    @DisplayName("Should return 404 for non-existent endpoints")
    void testNotFoundEndpoint() throws Exception {
        mockMvc.perform(get("/api/v1/nonexistent")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
