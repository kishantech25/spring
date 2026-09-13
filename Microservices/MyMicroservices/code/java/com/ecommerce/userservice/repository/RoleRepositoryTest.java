package com.ecommerce.userservice.repository;

import com.ecommerce.userservice.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("RoleRepository Tests")
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    private Role testRole;

    @BeforeEach
    void setUp() {
        testRole = new Role();
        testRole.setName("CUSTOMER");
        testRole.setDescription("Customer role");
    }

    @Test
    @DisplayName("Should save role successfully")
    void testSaveRole() {
        Role savedRole = roleRepository.save(testRole);
        
        assertNotNull(savedRole.getId());
        assertEquals("CUSTOMER", savedRole.getName());
    }

    @Test
    @DisplayName("Should find role by name")
    void testFindByName() {
        roleRepository.save(testRole);
        Optional<Role> foundRole = roleRepository.findByName("CUSTOMER");
        
        assertTrue(foundRole.isPresent());
        assertEquals("Customer role", foundRole.get().getDescription());
    }

    @Test
    @DisplayName("Should return empty when role name not found")
    void testFindByNameNotFound() {
        Optional<Role> foundRole = roleRepository.findByName("NONEXISTENT");
        
        assertTrue(foundRole.isEmpty());
    }

    @Test
    @DisplayName("Should check if role name exists")
    void testExistsByName() {
        roleRepository.save(testRole);
        
        assertTrue(roleRepository.existsByName("CUSTOMER"));
        assertFalse(roleRepository.existsByName("ADMIN"));
    }

    @Test
    @DisplayName("Should find role by id")
    void testFindById() {
        Role savedRole = roleRepository.save(testRole);
        Optional<Role> foundRole = roleRepository.findById(savedRole.getId());
        
        assertTrue(foundRole.isPresent());
        assertEquals("CUSTOMER", foundRole.get().getName());
    }

    @Test
    @DisplayName("Should delete role by id")
    void testDeleteRole() {
        Role savedRole = roleRepository.save(testRole);
        Long roleId = savedRole.getId();
        
        roleRepository.deleteById(roleId);
        Optional<Role> deletedRole = roleRepository.findById(roleId);
        
        assertTrue(deletedRole.isEmpty());
    }

    @Test
    @DisplayName("Should update role successfully")
    void testUpdateRole() {
        Role savedRole = roleRepository.save(testRole);
        savedRole.setDescription("Updated description");
        
        Role updatedRole = roleRepository.save(savedRole);
        
        assertEquals("Updated description", updatedRole.getDescription());
    }
}
