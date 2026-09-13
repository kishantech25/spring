package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.AdminCreateUserRequest;
import com.ecommerce.userservice.dto.UpdateUserRolesRequest;
import com.ecommerce.userservice.dto.UpdateUserStatusRequest;
import com.ecommerce.userservice.dto.UserResponseDto;
import com.ecommerce.userservice.entity.Role;
import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.entity.UserStatus;
import com.ecommerce.userservice.exception.ResourceAlreadyExistsException;
import com.ecommerce.userservice.exception.ResourceNotFoundException;
import com.ecommerce.userservice.repository.RoleRepository;
import com.ecommerce.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("AdminUserService Tests")
class AdminUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private AdminUserService adminUserService;

    private User testUser;
    private Role testRole;
    private AdminCreateUserRequest createUserRequest;

    @BeforeEach
    void setUp() {
        testUser = new User("test@example.com", "testuser", "password123");
        testUser.setId(1L);
        testUser.setStatus(UserStatus.ACTIVE);

        testRole = new Role("CUSTOMER", "Customer role");
        testRole.setId(1L);

        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        createUserRequest = new AdminCreateUserRequest("test@example.com", "testuser", "password123", roles);
    }

    @Test
    @DisplayName("Should create user successfully")
    void testCreateUserSuccess() {
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(roleRepository.findByName("CUSTOMER")).thenReturn(Optional.of(testRole));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        UserResponseDto result = adminUserService.createUser(createUserRequest);

        assertNotNull(result);
        assertEquals("test@example.com", result.email());
        assertEquals("testuser", result.username());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when email already exists")
    void testCreateUserEmailAlreadyExists() {
        when(userRepository.existsByEmail("test@example.com")).thenReturn(true);

        assertThrows(ResourceAlreadyExistsException.class, () -> adminUserService.createUser(createUserRequest));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when username already exists")
    void testCreateUserUsernameAlreadyExists() {
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        assertThrows(ResourceAlreadyExistsException.class, () -> adminUserService.createUser(createUserRequest));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when role not found")
    void testCreateUserRoleNotFound() {
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(roleRepository.findByName("CUSTOMER")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminUserService.createUser(createUserRequest));
    }

    @Test
    @DisplayName("Should get all users with pagination")
    void testGetAllUsers() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<User> userPage = new PageImpl<>(List.of(testUser), pageable, 1);
        when(userRepository.findAll(pageable)).thenReturn(userPage);

        Page<UserResponseDto> result = adminUserService.getAllUsers(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        verify(userRepository, times(1)).findAll(pageable);
    }

    @Test
    @DisplayName("Should get user by id successfully")
    void testGetUserByIdSuccess() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        UserResponseDto result = adminUserService.getUserById(1L);

        assertNotNull(result);
        assertEquals("test@example.com", result.email());
    }

    @Test
    @DisplayName("Should throw exception when user not found")
    void testGetUserByIdNotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminUserService.getUserById(999L));
    }

    @Test
    @DisplayName("Should update user status successfully")
    void testUpdateUserStatusSuccess() {
        UpdateUserStatusRequest request = new UpdateUserStatusRequest("SUSPENDED");
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        UserResponseDto result = adminUserService.updateUserStatus(1L, request);

        assertNotNull(result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception for invalid user status")
    void testUpdateUserStatusInvalid() {
        UpdateUserStatusRequest request = new UpdateUserStatusRequest("INVALID_STATUS");
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        assertThrows(IllegalArgumentException.class, () -> adminUserService.updateUserStatus(1L, request));
    }

    @Test
    @DisplayName("Should update user roles successfully")
    void testUpdateUserRolesSuccess() {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        UpdateUserRolesRequest request = new UpdateUserRolesRequest(roles);
        
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(roleRepository.findByName("ADMIN")).thenReturn(Optional.of(testRole));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        UserResponseDto result = adminUserService.updateUserRoles(1L, request);

        assertNotNull(result);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should delete user successfully")
    void testDeleteUserSuccess() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        doNothing().when(userRepository).delete(testUser);

        adminUserService.deleteUser(1L);

        verify(userRepository, times(1)).delete(testUser);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent user")
    void testDeleteUserNotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminUserService.deleteUser(999L));
    }
}
