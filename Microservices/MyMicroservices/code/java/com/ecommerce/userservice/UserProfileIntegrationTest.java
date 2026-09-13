package com.ecommerce.userservice;

import com.ecommerce.userservice.dto.CreateProfileRequest;
import com.ecommerce.userservice.dto.AddressRequestDto;
import com.ecommerce.userservice.dto.UpdateProfileRequest;
import com.ecommerce.userservice.repository.UserProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("User Profile Integration Tests")
class UserProfileIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @BeforeEach
    void setUp() {
        userProfileRepository.deleteAll();
    }

    @Test
    @DisplayName("Should create and retrieve profile successfully")
    void testCreateAndRetrieveProfile() throws Exception {
        AddressRequestDto address = new AddressRequestDto(
                "HOME", "123 Main St", "Apt 4B", "New York", "NY", "USA", "10001"
        );

        CreateProfileRequest request = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", address
        );

        var createdResponse = mockMvc.perform(post("/api/v1/users/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("userId").asLong();

        mockMvc.perform(get("/api/v1/users/profile/" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    @DisplayName("Should update profile completely")
    void testUpdateProfileIntegration() throws Exception {
        AddressRequestDto address = new AddressRequestDto(
                "HOME", "123 Main St", null, "New York", "NY", "USA", "10001"
        );

        CreateProfileRequest createRequest = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", address
        );

        var createdResponse = mockMvc.perform(post("/api/v1/users/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("userId").asLong();

        AddressRequestDto updatedAddress = new AddressRequestDto(
                "OFFICE", "456 Oak Ave", null, "Boston", "MA", "USA", "02101"
        );

        UpdateProfileRequest updateRequest = new UpdateProfileRequest(
                "Jane", "Smith", "9876543211", "15/06/1992", "F",
                "https://example.com/image.jpg", updatedAddress
        );

        mockMvc.perform(put("/api/v1/users/profile/" + userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/users/profile/" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jane"));
    }

    @Test
    @DisplayName("Should patch profile partially")
    void testPatchProfileIntegration() throws Exception {
        AddressRequestDto address = new AddressRequestDto(
                "HOME", "123 Main St", null, "New York", "NY", "USA", "10001"
        );

        CreateProfileRequest createRequest = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", address
        );

        var createdResponse = mockMvc.perform(post("/api/v1/users/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("userId").asLong();

        UpdateProfileRequest patchRequest = new UpdateProfileRequest(
                "Jane", null, null, null, null, null, null
        );

        mockMvc.perform(patch("/api/v1/users/profile/" + userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patchRequest)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/users/profile/" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Doe"));
    }

    @Test
    @DisplayName("Should delete profile successfully")
    void testDeleteProfileIntegration() throws Exception {
        AddressRequestDto address = new AddressRequestDto(
                "HOME", "123 Main St", null, "New York", "NY", "USA", "10001"
        );

        CreateProfileRequest request = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", address
        );

        var createdResponse = mockMvc.perform(post("/api/v1/users/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("userId").asLong();

        mockMvc.perform(delete("/api/v1/users/profile/" + userId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/v1/users/profile/" + userId))
                .andExpect(status().isNotFound());
    }
}
