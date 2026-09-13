package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.CreateProfileRequest;
import com.ecommerce.userservice.dto.AddressRequestDto;
import com.ecommerce.userservice.dto.UpdateProfileRequest;
import com.ecommerce.userservice.entity.UserProfile;
import com.ecommerce.userservice.entity.Address;
import com.ecommerce.userservice.exception.ResourceNotFoundException;
import com.ecommerce.userservice.repository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UserProfileService Tests")
class UserProfileServiceTest {

    @Mock
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    private UserProfile testProfile;
    private CreateProfileRequest createProfileRequest;
    private AddressRequestDto addressRequestDto;

    @BeforeEach
    void setUp() {
        testProfile = new UserProfile();
        testProfile.setId(1L);
        testProfile.setUserId(1L);
        testProfile.setFirstName("John");
        testProfile.setLastName("Doe");
        testProfile.setPhone("9876543210");
        testProfile.setDateOfBirth(LocalDate.of(1990, 12, 25));

        addressRequestDto = new AddressRequestDto(
                "HOME", "123 Main St", "Apt 4B", "New York", "NY", "USA", "10001"
        );

        createProfileRequest = new CreateProfileRequest(
                "John", "Doe", "9876543210", "25/12/1990", addressRequestDto
        );
    }

    @Test
    @DisplayName("Should create profile successfully")
    void testCreateProfileSuccess() {
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(testProfile);

        UserProfile result = userProfileService.createProfile(createProfileRequest);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
    }

    @Test
    @DisplayName("Should get profile by userId successfully")
    void testGetProfileByUserIdSuccess() {
        when(userProfileRepository.findByUserId(1L)).thenReturn(Optional.of(testProfile));

        UserProfile result = userProfileService.getProfileByUserId(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
    }

    @Test
    @DisplayName("Should throw exception when profile not found")
    void testGetProfileByUserIdNotFound() {
        when(userProfileRepository.findByUserId(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userProfileService.getProfileByUserId(999L));
    }

    @Test
    @DisplayName("Should update profile completely")
    void testUpdateProfileSuccess() {
        UpdateProfileRequest updateRequest = new UpdateProfileRequest(
                "Jane", "Smith", "9876543211", "15/06/1992", "F", 
                "https://example.com/image.jpg", addressRequestDto
        );

        when(userProfileRepository.findByUserId(1L)).thenReturn(Optional.of(testProfile));
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(testProfile);

        UserProfile result = userProfileService.updateProfile(1L, updateRequest);

        assertNotNull(result);
        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
    }

    @Test
    @DisplayName("Should patch profile successfully")
    void testPatchProfileSuccess() {
        UpdateProfileRequest patchRequest = new UpdateProfileRequest(
                "Jane", null, null, null, null, null, null
        );

        when(userProfileRepository.findByUserId(1L)).thenReturn(Optional.of(testProfile));
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(testProfile);

        UserProfile result = userProfileService.patchProfile(1L, patchRequest);

        assertNotNull(result);
        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
    }

    @Test
    @DisplayName("Should delete profile successfully")
    void testDeleteProfileSuccess() {
        when(userProfileRepository.findByUserId(1L)).thenReturn(Optional.of(testProfile));
        doNothing().when(userProfileRepository).delete(testProfile);

        userProfileService.deleteProfile(1L);

        verify(userProfileRepository, times(1)).delete(testProfile);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent profile")
    void testDeleteProfileNotFound() {
        when(userProfileRepository.findByUserId(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userProfileService.deleteProfile(999L));
    }

    @Test
    @DisplayName("Should handle date parsing correctly")
    void testDateParsing() {
        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(testProfile);

        UserProfile result = userProfileService.createProfile(createProfileRequest);

        assertNotNull(result);
        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
    }
}
