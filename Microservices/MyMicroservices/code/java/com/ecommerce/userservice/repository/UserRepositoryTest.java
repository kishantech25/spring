package com.ecommerce.userservice.repository;

import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.entity.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@DisplayName("UserRepository Tests")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setEmail("test@example.com");
        testUser.setUsername("testuser");
        testUser.setPassword("password123");
        testUser.setStatus(UserStatus.ACTIVE);
    }

    @Test
    @DisplayName("Should save user successfully")
    void testSaveUser() {
        User savedUser = userRepository.save(testUser);
        
        assertNotNull(savedUser.getId());
        assertEquals("test@example.com", savedUser.getEmail());
        assertEquals("testuser", savedUser.getUsername());
    }

    @Test
    @DisplayName("Should find user by email")
    void testFindByEmail() {
        userRepository.save(testUser);
        Optional<User> foundUser = userRepository.findByEmail("test@example.com");
        
        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
    }

    @Test
    @DisplayName("Should return empty when email not found")
    void testFindByEmailNotFound() {
        Optional<User> foundUser = userRepository.findByEmail("nonexistent@example.com");
        
        assertTrue(foundUser.isEmpty());
    }

    @Test
    @DisplayName("Should find user by username")
    void testFindByUsername() {
        userRepository.save(testUser);
        Optional<User> foundUser = userRepository.findByUsername("testuser");
        
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmail());
    }

    @Test
    @DisplayName("Should return empty when username not found")
    void testFindByUsernameNotFound() {
        Optional<User> foundUser = userRepository.findByUsername("nonexistent");
        
        assertTrue(foundUser.isEmpty());
    }

    @Test
    @DisplayName("Should check if email exists")
    void testExistsByEmail() {
        userRepository.save(testUser);
        
        assertTrue(userRepository.existsByEmail("test@example.com"));
        assertFalse(userRepository.existsByEmail("notexist@example.com"));
    }

    @Test
    @DisplayName("Should check if username exists")
    void testExistsByUsername() {
        userRepository.save(testUser);
        
        assertTrue(userRepository.existsByUsername("testuser"));
        assertFalse(userRepository.existsByUsername("notexist"));
    }

    @Test
    @DisplayName("Should update user successfully")
    void testUpdateUser() {
        User savedUser = userRepository.save(testUser);
        savedUser.setStatus(UserStatus.SUSPENDED);
        
        User updatedUser = userRepository.save(savedUser);
        
        assertEquals(UserStatus.SUSPENDED, updatedUser.getStatus());
    }

    @Test
    @DisplayName("Should delete user by id")
    void testDeleteUser() {
        User savedUser = userRepository.save(testUser);
        Long userId = savedUser.getId();
        
        userRepository.deleteById(userId);
        Optional<User> deletedUser = userRepository.findById(userId);
        
        assertTrue(deletedUser.isEmpty());
    }

    @Test
    @DisplayName("Should find user by id")
    void testFindById() {
        User savedUser = userRepository.save(testUser);
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmail());
    }
}
