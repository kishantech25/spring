package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.AdminCreateUserRequest;
import com.ecommerce.userservice.dto.UpdateUserRolesRequest;
import com.ecommerce.userservice.dto.UpdateUserStatusRequest;
import com.ecommerce.userservice.dto.UserResponseDto;
import com.ecommerce.userservice.entity.UserStatus;
import com.ecommerce.userservice.service.AdminUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AdminUserController.class)
@DisplayName("AdminUserController Tests")
class AdminUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AdminUserService adminUserService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserResponseDto testUserDto;
    private AdminCreateUserRequest createUserRequest;

    @BeforeEach
    void setUp() {
        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");
        
        testUserDto = new UserResponseDto(
                1L,
                "test@example.com",
                "testuser",
                UserStatus.ACTIVE,
                roles,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        createUserRequest = new AdminCreateUserRequest(
                "test@example.com",
                "testuser",
                "password123",
                roles
        );
    }

    @Test
    @DisplayName("Should create user successfully")
    void testCreateUserSuccess() throws Exception {
        when(adminUserService.createUser(any(AdminCreateUserRequest.class))).thenReturn(testUserDto);

        mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createUserRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.username").value("testuser"));

        verify(adminUserService, times(1)).createUser(any(AdminCreateUserRequest.class));
    }

    @Test
    @DisplayName("Should get all users with pagination")
    void testGetAllUsersSuccess() throws Exception {
        Page<UserResponseDto> userPage = new PageImpl<>(List.of(testUserDto), PageRequest.of(0, 10), 1);
        when(adminUserService.getAllUsers(any())).thenReturn(userPage);

        mockMvc.perform(get("/api/v1/admin/users?page=0&size=10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].email").value("test@example.com"));

        verify(adminUserService, times(1)).getAllUsers(any());
    }

    @Test
    @DisplayName("Should get user by id successfully")
    void testGetUserByIdSuccess() throws Exception {
        when(adminUserService.getUserById(1L)).thenReturn(testUserDto);

        mockMvc.perform(get("/api/v1/admin/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"));

        verify(adminUserService, times(1)).getUserById(1L);
    }

    @Test
    @DisplayName("Should return 404 when user not found")
    void testGetUserByIdNotFound() throws Exception {
        when(adminUserService.getUserById(999L)).thenThrow(new com.ecommerce.userservice.exception.ResourceNotFoundException("User not found"));

        mockMvc.perform(get("/api/v1/admin/users/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(adminUserService, times(1)).getUserById(999L);
    }

    @Test
    @DisplayName("Should update user status successfully")
    void testUpdateUserStatusSuccess() throws Exception {
        UpdateUserStatusRequest request = new UpdateUserStatusRequest("SUSPENDED");
        when(adminUserService.updateUserStatus(eq(1L), any(UpdateUserStatusRequest.class))).thenReturn(testUserDto);

        mockMvc.perform(patch("/api/v1/admin/users/1/status")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"));

        verify(adminUserService, times(1)).updateUserStatus(eq(1L), any(UpdateUserStatusRequest.class));
    }

    @Test
    @DisplayName("Should update user roles successfully")
    void testUpdateUserRolesSuccess() throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        UpdateUserRolesRequest request = new UpdateUserRolesRequest(roles);
        when(adminUserService.updateUserRoles(eq(1L), any(UpdateUserRolesRequest.class))).thenReturn(testUserDto);

        mockMvc.perform(patch("/api/v1/admin/users/1/roles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"));

        verify(adminUserService, times(1)).updateUserRoles(eq(1L), any(UpdateUserRolesRequest.class));
    }

    @Test
    @DisplayName("Should delete user successfully")
    void testDeleteUserSuccess() throws Exception {
        doNothing().when(adminUserService).deleteUser(1L);

        mockMvc.perform(delete("/api/v1/admin/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(adminUserService, times(1)).deleteUser(1L);
    }

    @Test
    @DisplayName("Should return 404 when deleting non-existent user")
    void testDeleteUserNotFound() throws Exception {
        doThrow(new com.ecommerce.userservice.exception.ResourceNotFoundException("User not found"))
                .when(adminUserService).deleteUser(999L);

        mockMvc.perform(delete("/api/v1/admin/users/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(adminUserService, times(1)).deleteUser(999L);
    }
}
