package com.revature.bank;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    public void nameTest() {
        assertTrue(User.validName("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
        assertFalse(User.validName("qq5235dd"));
        assertTrue(User.validName("àéë ïĳ"));
        assertTrue(User.validName("ÆØÅæøåÄÖÜäöüß"));
    }

    @RepeatedTest(value = 20)
    public void passwordHashTest() {
        User user = new User("user", "userpass");

        assertTrue(user.correctPassword("userpass"));
        assertFalse(user.correctPassword("notuserpass"));
    }

    @Test
    public void passwordTest() {
        assertTrue(User.validPassword("password1$"));
        assertFalse(User.validPassword("password1"));
        assertFalse(User.validPassword("p1$"));
        assertFalse(User.validPassword("password=that0is-long"));
    }
}