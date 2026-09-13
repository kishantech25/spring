package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.CreateProfileRequest;
import com.ecommerce.userservice.dto.AddressRequestDto;
import com.ecommerce.userservice.dto.UpdateProfileRequest;
import com.ecommerce.userservice.entity.UserProfile;
import com.ecommerce.userservice.entity.Address;
import com.ecommerce.userservice.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserProfileController.class)
@DisplayName("UserProfileController Tests")
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserProfileService userProfileService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserProfile testProfile;
    private CreateProfileRequest createProfileRequest;
    private AddressRequestDto addressRequestDto;

    @BeforeEach
    void setUp() {
        addressRequestDto = new AddressRequestDto(
                "HOME", "123 Main St", "Apt 4B", "New York", "NY", "USA", "10001"
        );

        testProfile = new UserProfile();
        testProfile.setId(1L);
        testProfile.setUserId(1L);
        testProfile.setFirstName("John");
        testProfile.setLastName("Doe");
        testProfile.setPhone("9876543210");
        testProfile.setDateOfBirth(LocalDate.of(1990, 12, 25));

        Address address = new Address();
        address.setAddressType("HOME");
        address.setAddressLine1("123 Main St");
        address.setCity("New York");
        address.setState("NY");
        address.setCountry("USA");
        address.setPincode("10001");
        testProfile.setAddresses(List.of(address));

        createProfileRequest = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", addressRequestDto
        );
    }

    @Test
    @DisplayName("Should create profile successfully")
    void testCreateProfileSuccess() throws Exception {
        when(userProfileService.createProfile(any(CreateProfileRequest.class))).thenReturn(testProfile);

        mockMvc.perform(post("/api/v1/users/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createProfileRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"));

        verify(userProfileService, times(1)).createProfile(any(CreateProfileRequest.class));
    }

    @Test
    @DisplayName("Should get profile by userId successfully")
    void testGetProfileSuccess() throws Exception {
        when(userProfileService.getProfileByUserId(1L)).thenReturn(testProfile);

        mockMvc.perform(get("/api/v1/users/profile/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.userId").value(1));

        verify(userProfileService, times(1)).getProfileByUserId(1L);
    }

    @Test
    @DisplayName("Should return 404 when profile not found")
    void testGetProfileNotFound() throws Exception {
        when(userProfileService.getProfileByUserId(999L))
                .thenThrow(new com.ecommerce.userservice.exception.ResourceNotFoundException("Profile not found"));

        mockMvc.perform(get("/api/v1/users/profile/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(userProfileService, times(1)).getProfileByUserId(999L);
    }

    @Test
    @DisplayName("Should update profile completely")
    void testUpdateProfileSuccess() throws Exception {
        UpdateProfileRequest updateRequest = new UpdateProfileRequest(
                "Jane", "Smith", "9876543211", "15/06/1992", "F",
                "https://example.com/image.jpg", addressRequestDto
        );

        when(userProfileService.updateProfile(eq(1L), any(UpdateProfileRequest.class))).thenReturn(testProfile);

        mockMvc.perform(put("/api/v1/users/profile/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));

        verify(userProfileService, times(1)).updateProfile(eq(1L), any(UpdateProfileRequest.class));
    }

    @Test
    @DisplayName("Should patch profile partially")
    void testPatchProfileSuccess() throws Exception {
        UpdateProfileRequest patchRequest = new UpdateProfileRequest(
                "Jane", null, null, null, null, null, null
        );

        when(userProfileService.patchProfile(eq(1L), any(UpdateProfileRequest.class))).thenReturn(testProfile);

        mockMvc.perform(patch("/api/v1/users/profile/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patchRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));

        verify(userProfileService, times(1)).patchProfile(eq(1L), any(UpdateProfileRequest.class));
    }

    @Test
    @DisplayName("Should delete profile successfully")
    void testDeleteProfileSuccess() throws Exception {
        doNothing().when(userProfileService).deleteProfile(1L);

        mockMvc.perform(delete("/api/v1/users/profile/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(userProfileService, times(1)).deleteProfile(1L);
    }

    @Test
    @DisplayName("Should return 404 when deleting non-existent profile")
    void testDeleteProfileNotFound() throws Exception {
        doThrow(new com.ecommerce.userservice.exception.ResourceNotFoundException("Profile not found"))
                .when(userProfileService).deleteProfile(999L);

        mockMvc.perform(delete("/api/v1/users/profile/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(userProfileService, times(1)).deleteProfile(999L);
    }
}
