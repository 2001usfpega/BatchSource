package com.revature.parker;

import static org.junit.jupiter.api.Assertions.*;

import static com.revature.parker.CoreJavaAssignment.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class CoreJavaAssignmentTest {

    @Test
    public void testQ1() {
        int[] unsorted = new int[]{1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        int[] sorted = new int[]{0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};

        CoreJavaAssignment.bubbleSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    public void testQ2() {
        assertEquals("0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393", CoreJavaAssignment.fibonacci());
    }

    @Test
    public void testQ3() {
        assertEquals("test", CoreJavaAssignment.reverse("tset"));
        assertEquals("", CoreJavaAssignment.reverse(""));
        assertEquals("12345", CoreJavaAssignment.reverse("54321"));
    }

    @Test
    public void testQ4() {
        assertEquals(362880, CoreJavaAssignment.factorial(9));
    }

    @Test
    public void testQ5() {
        assertEquals("sub", substring("substring", 3));
    }

    @Test
    public void testQ6() {
        assertTrue(isEven(0));
        assertFalse(isEven(1));
        assertTrue(isEven(2));
        assertFalse(isEven(3));
    }

    @Test
    public void testQ7() {
        Employee jim = new Employee("Jim", "Dunder Mifflin", 25);
        Employee pam = new Employee("Pam", "Dunder Mifflin", 27);

        assertEquals(Arrays.asList(jim, pam), sort(Arrays.asList(jim, pam)));
    }

    @Test
    public void testQ8() {
        assertEquals(Arrays.asList("madam", "civic", "radar", "kayak", "refer", "did"),
                palindromes(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did")));
    }

    @Test
    public void testQ9() {
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97), primes());
    }

    @Test
    public void testQ10() {
        assertEquals(22, min(22, 523));
        assertEquals(22, min(523, 22));
    }

    @Test
    public void testQ11() {
        assertEquals(4678.2f, floats());
    }

    @Test
    public void testQ12() {
        even100();
    }

    @Test
    public void testQ13() {
        triangle();
    }

    @Test
    public void testQ14() {
        assertEquals(1.0, switches(1));
        assertEquals(2.0, switches(2));
        assertEquals(3.0, switches(3));
    }

    @Test
    public void testQ15() {
        maths();
    }

    @Test
    public void testQ16() {
        assertEquals(7, characters("This", "is", "7"));
    }

    @Test
    public void testQ17() {
        System.setIn(new ByteArrayInputStream("2.95 5.2 7.512".getBytes()));

        assertEquals(115.23408, interest());
    }

    @Test
    public void testQ18() {
        strings();
    }

    @Test
    public void testQ19() {
        assertEquals(Arrays.asList(1, 4, 6, 8, 9, 10), primes10());
    }

    @Test
    public void testQ20() {
        data();
    }
}