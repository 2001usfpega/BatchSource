package com.revature.bank.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void nameTest() {
        Assertions.assertTrue(User.validName("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
        Assertions.assertFalse(User.validName("qq5235dd"));
        Assertions.assertTrue(User.validName("àéë ïĳ"));
        Assertions.assertTrue(User.validName("ÆØÅæøåÄÖÜäöüß"));
    }

    @RepeatedTest(value = 20)
    public void passwordHashTest() {
        User user = new User("user", "userpass");

        Assertions.assertTrue(user.correctPassword("userpass"));
        Assertions.assertFalse(user.correctPassword("notuserpass"));
    }

    @Test
    public void passwordTest() {
        Assertions.assertTrue(User.validPassword("paTssword1$"));
        Assertions.assertTrue(User.validPassword("%te$s%TTt3423%%"));
        Assertions.assertFalse(User.validPassword("password1"));
        Assertions.assertFalse(User.validPassword("p1$"));
    }
}