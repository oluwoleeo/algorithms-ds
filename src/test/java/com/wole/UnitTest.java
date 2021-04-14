package com.wole;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    @DisplayName("Binary search")
    public void TestBinarySearch(){
        int[] array = new int[]{20, 23, 12, 7, 3, 16, 21, 9, 25, 22 };
        int elem = 7; // 3 7 9 12 16 20 21 22 23 25

        int actual = Algos.BinarySearch(7, array);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Binary search for non-existing element")
    public void TestBinarySearchNonExisting(){
        int[] array = new int[]{20, 23, 12, 7, 3, 16, 21, 9, 25, 22 };
        int elem = 7; // 3 7 9 12 16 20 21 22 23 25

        int actual = Algos.BinarySearch(666, array);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }
}
