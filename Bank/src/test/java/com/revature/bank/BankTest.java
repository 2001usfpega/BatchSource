package com.revature.bank;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class BankTest {

    @Test
    public void bankTest() {
        StringBuilder builder = new StringBuilder();

        builder.append("2\n");
        builder.append("admin\n");
        builder.append("admin\n");
        builder.append("1\n");
        builder.append("5\n");
        builder.append("3\n");

        System.setIn(new ByteArrayInputStream(builder.toString().getBytes()));

        Bank bank = new Bank();
        bank.openMenu(MenuType.LOGIN);
    }
}