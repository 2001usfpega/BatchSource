package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {
    
    @BeforeAll
    static void beforeAllOfEm() {
        System.out.println("Before All");
    }
    @AfterEach
    void afterEach() {
        System.out.println("We just ran: "+ info.getDisplayName());
    }

    @DisplayName("Length Check")
    @Test
    public void meh() {
        int actualLength = "ABCD".length();
        int expectedLength =4;
        assertEquals(expectedLength, actualLength);
    }

}
