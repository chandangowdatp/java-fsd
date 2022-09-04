package com.auth;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;


public class AuthenticationTest {
    @BeforeAll
    @DisplayName("First Testcase.")
    static void authenticationTestCase() {
        Auth.inputUserName();
        Auth.inputPassword();
        assertNotNull(Auth.enteredUserName);
        assertNotNull(Auth.enteredPassword);
    }

    @Test
    @DisplayName("Testcase to validate username")
    void validateUserName() {
        assertEquals(Auth.correctUserName,Auth.enteredUserName);
    }

    @Test
    @DisplayName("Testcase to validate password")
    void validatePassword() {
        assertEquals(Auth.correctPassword, Auth.enteredPassword);
    }

    @AfterAll
    @DisplayName("Last Testcase.")
    static void last() {
        if (Auth.authenticate()) {
            System.out.println("Valid credentials.");
        }
        else {
            System.out.println("Invalid credentials.");
        }
        Auth.enteredUserName = null;
        Auth.enteredPassword = null;
        assertNull(Auth.enteredUserName);
        assertNull(Auth.enteredPassword);
    }
}