package com.revature.bank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void nameTest() {
        assertTrue(User.validName("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
        assertFalse(User.validName("qq5235dd"));
        assertTrue(User.validName("àéë ïĳ"));
        assertTrue(User.validName("ÆØÅæøåÄÖÜäöüß"));
    }

    @Test
    public void passwordTest() {
        String pass1 = "test1";
        String pass2 = "test2";

        assertFalse(Arrays.equals(User.hashPassword(pass1), User.hashPassword(pass2)));
        assertArrayEquals(User.hashPassword(pass1), User.hashPassword(pass1));
        assertArrayEquals(User.hashPassword(pass2), User.hashPassword(pass2));
    }
}