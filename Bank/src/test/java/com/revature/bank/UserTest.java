package com.revature.bank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class UserTest {

    @Test
    public void nameTest() {
        Assert.assertTrue(User.validName("ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
        Assert.assertFalse(User.validName("qq5235dd"));
        Assert.assertTrue(User.validName("àéë ïĳ"));
        Assert.assertTrue(User.validName("ÆØÅæøåÄÖÜäöüß"));
    }

    @Test
    public void passwordTest() {
        String pass1 = "test1";
        String pass2 = "test2";

        Assert.assertFalse(Arrays.equals(User.hashPassword(pass1), User.hashPassword(pass2)));
        Assert.assertArrayEquals(User.hashPassword(pass1), User.hashPassword(pass1));
        Assert.assertArrayEquals(User.hashPassword(pass2), User.hashPassword(pass2));
    }
}