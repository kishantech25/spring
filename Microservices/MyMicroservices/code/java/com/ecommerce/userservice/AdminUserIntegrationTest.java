package com.ecommerce.userservice;

import com.ecommerce.userservice.dto.AdminCreateUserRequest;
import com.ecommerce.userservice.dto.UpdateUserStatusRequest;
import com.ecommerce.userservice.entity.Role;
import com.ecommerce.userservice.entity.UserStatus;
import com.ecommerce.userservice.repository.RoleRepository;
import com.ecommerce.userservice.repository.UserRepository;
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

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("Admin User Integration Tests")
class AdminUserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        roleRepository.deleteAll();

        Role customerRole = new Role("CUSTOMER", "Customer role");
        roleRepository.save(customerRole);
    }

    @Test
    @DisplayName("Should create and retrieve user successfully")
    void testCreateAndRetrieveUser() throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");

        AdminCreateUserRequest request = new AdminCreateUserRequest(
                "integration@test.com",
                "inttest",
                "password123",
                roles
        );

        mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("integration@test.com"));

        mockMvc.perform(get("/api/v1/admin/users?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].email").value("integration@test.com"));
    }

    @Test
    @DisplayName("Should reject duplicate email")
    void testDuplicateEmailRejection() throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");

        AdminCreateUserRequest request = new AdminCreateUserRequest(
                "duplicate@test.com",
                "user1",
                "password123",
                roles
        );

        mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        AdminCreateUserRequest duplicateRequest = new AdminCreateUserRequest(
                "duplicate@test.com",
                "user2",
                "password123",
                roles
        );

        mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(duplicateRequest)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error").value("Resource Already Exists"));
    }

    @Test
    @DisplayName("Should update user status successfully")
    void testUpdateUserStatusIntegration() throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");

        AdminCreateUserRequest createRequest = new AdminCreateUserRequest(
                "status@test.com",
                "statustest",
                "password123",
                roles
        );

        var createdResponse = mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createRequest)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("id").asLong();

        UpdateUserStatusRequest statusRequest = new UpdateUserStatusRequest("SUSPENDED");

        mockMvc.perform(patch("/api/v1/admin/users/" + userId + "/status")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(statusRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUSPENDED"));
    }

    @Test
    @DisplayName("Should delete user successfully")
    void testDeleteUserIntegration() throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add("CUSTOMER");

        AdminCreateUserRequest request = new AdminCreateUserRequest(
                "delete@test.com",
                "deletetest",
                "password123",
                roles
        );

        var createdResponse = mockMvc.perform(post("/api/v1/admin/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(createdResponse).get("id").asLong();

        mockMvc.perform(delete("/api/v1/admin/users/" + userId))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/v1/admin/users/" + userId))
                .andExpect(status().isNotFound());
    }
}
