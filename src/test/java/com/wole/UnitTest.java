package com.wole;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    @DisplayName("Merge Array")
    public void MergeArray(){
        List<Integer> a = new ArrayList<>(Arrays.asList(1,5,7,7));
        List<Integer> b = new ArrayList<>(Arrays.asList(0,1,2,3));
        int elem = 7; // 3 7 9 12 16 20 21 22 23 25

        List<Integer> actual = Algos.mergeArrays(a, b);
        List<Integer> expected = new ArrayList<>(Arrays.asList(0,1, 1, 2,3, 5, 7, 7));

        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Pascal")
    public void PascalTest(){
        int actual = Algos.Pascal(6, 3);
        int expected = 10;

        Assertions.assertEquals(expected, actual);
    }
}
