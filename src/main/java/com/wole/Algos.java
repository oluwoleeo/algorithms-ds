package com.wole;

import java.util.Arrays;
import java.util.Iterator;

public class Algos {

    public static void main(String[] args) {
	// write your code here
        // System.out.println(FibonacciDP(20));
        /* for(int elem: BubbleSort(new int[]{5,25,64,71,17,22,100,99,3,2})){
            System.out.printf("%d ", elem);
        } */

        /* CircularList<Integer> newCircularList = new CircularList<>();
        newCircularList.insertAtBeginning(7);
        newCircularList.insertAtBeginning(6);
        newCircularList.insertAtEnd(4);
        newCircularList.insertAtEnd(21);
        newCircularList.insertAtEnd(54);
        newCircularList.insert(2,77);
        IterateCircularList(newCircularList);
        System.out.println();
        System.out.println(newCircularList.getLength());

        System.out.println("Delete from beginning");
        System.out.println(newCircularList.deleteFromBeginning());
        IterateCircularList(newCircularList);
        System.out.println();
        System.out.println(newCircularList.getLength());

        System.out.println("Delete from end");
        System.out.println(newCircularList.deleteFromEnd());
        IterateCircularList(newCircularList);
        System.out.println();
        System.out.println(newCircularList.getLength());

        System.out.println("Delete from pos 2");
        System.out.println(newCircularList.delete(2));
        IterateCircularList(newCircularList);
        System.out.println();
        System.out.println(newCircularList.getLength()); */

        /* DoublyLinkedList<Integer> newDoubleList = new DoublyLinkedList<>();

        newDoubleList.InsertAtBeginning(5);
        newDoubleList.InsertAtBeginning(4);
        newDoubleList.InsertAtEnd(7);
        newDoubleList.Insert(2, 51);
        newDoubleList.Insert(4, 52);
        newDoubleList.Insert(4, 53);
        newDoubleList.Insert(4, 50);
        newDoubleList.Insert(5, 8);
        newDoubleList.Insert(7, 6);
        newDoubleList.Insert(10, 55);
        newDoubleList.InsertAtEnd(666);

        IterateDoubleList(newDoubleList);
        System.out.println();
        System.out.println(newDoubleList.GetLength());

        System.out.println(newDoubleList.DeleteFromBeginning());
        System.out.println(newDoubleList.DeleteFromBeginning());
        System.out.println(newDoubleList.Delete(7));
        System.out.println(newDoubleList.DeleteFromEnd());

        IterateDoubleList(newDoubleList);
        System.out.println();
        System.out.println(newDoubleList.GetLength());
        System.out.println(newDoubleList.GetNode(5).GetData());
        System.out.println(newDoubleList.GetNode(8));
        System.out.println(newDoubleList.GetPos(54)); */

        SinglyLinkedList<Integer> newSingleList = new SinglyLinkedList<>();
        newSingleList.Insert(0, 6);
        newSingleList.Insert(0, 1);
        newSingleList.Insert(1, 7);
        newSingleList.InsertAtEnd(666);
        newSingleList.InsertAtEnd(111);
        newSingleList.InsertAtEnd(222);
        newSingleList.InsertAtEnd(333);

        Iterator<Integer> iter = newSingleList.iterator();
        iter.remove();
        for (int x : newSingleList){
            System.out.printf("%d ", x);
        }
        System.out.println();

        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
       /*  System.out.println("Delete from beginning");
        System.out.println(newSingleList.DeleteFromBeginning());
        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
        System.out.println("Delete from end");
        System.out.println(newSingleList.DeleteFromEnd());
        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
        System.out.println("Delete from position 3");
        System.out.println(newSingleList.Delete(3));
        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
        System.out.println("Delete from position last");
        System.out.println(newSingleList.Delete(3));
        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
        System.out.println("Delete from position 0");
        System.out.println(newSingleList.Delete(0));
        IterateList(newSingleList);
        System.out.println();
        System.out.println("Delete from end");
        System.out.println(newSingleList.DeleteFromEnd());
        IterateList(newSingleList);
        System.out.println();
        System.out.println(newSingleList.GetLength());
        System.out.println("Get data at position 0");
        System.out.println(newSingleList.GetNode(0).getData());
        System.out.println("Get data at position 1");
        //System.out.println(newSingleList.GetNode(1).getData());
        System.out.println("Get position of data 6");
        System.out.println(newSingleList.GetPos(6));
        System.out.println("Get position of data 666");
        System.out.println(newSingleList.GetPos(666));
        System.out.println("Get position of data 7");
        System.out.println(newSingleList.GetPos(7)); */


    }

    public static void IterateList(SinglyLinkedList<Integer> newSingleList){
        Node<Integer> x = newSingleList.GetHead();

        while(x != null){
            if (x.getNext() != null){
                System.out.printf("data: %d, next: %d", x.getData(), x.getNext().getData());
            }
            else{
                System.out.printf("data: %d, next: %d", x.getData(), null);
            }
            x = x.getNext();
            System.out.println();
        }
    }

    public static void IterateCircularList(CircularList<Integer> newCircularList){
        Node<Integer> x = newCircularList.getHead();

        if (x != null){
            do {
                if (x.getNext() != null){
                    System.out.printf("data: %d, next: %d", x.getData(), x.getNext().getData());
                }
                else{
                    System.out.printf("data: %d, next: %d", x.getData(), null);
                }
                x = x.getNext();
                System.out.println();
            }
            while(x != newCircularList.getHead());
        }
    }

    public static void IterateDoubleList(DoublyLinkedList<Integer> newDoubleList){
        DoubleNode<Integer> x = newDoubleList.GetHead();
        while(x != null){
            if (x.GetPrev() == null){
                if (x.GetNext() == null){
                    System.out.printf("data: %d, prev: %d, next: %d", x.GetData(), null, null);
                }
                else{
                    System.out.printf("data: %d, prev: %d, next: %d", x.GetData(), null, x.GetNext().GetData());
                }
            }
            else if(x.GetNext() == null){
                System.out.printf("data: %d, prev: %d, next: %d", x.GetData(), x.GetPrev().GetData(), null);
            }
            else{
                System.out.printf("data: %d, prev: %d, next: %d", x.GetData(), x.GetPrev().GetData(), x.GetNext().GetData());
            }
            x = x.GetNext();
            System.out.println();
        }
    }

    public static int FibonacciDP(int n){
        int[] fibArr = new int[n+1];

        fibArr[0] = 0;
        fibArr[1] = 1;

        for(int i = 2; i <= n; i++){
            fibArr[i] = fibArr[i-1] + fibArr[i-2];
        }
        return fibArr[n];
    }

    public static int FibonacciDP1(int n){
        int f0 = 0, f1 = 1, f2 = 1;

        if (n == 0){
            return f0;
        }
        else if (n== 1){
            return f1;
        }
        else if (n == 2){
            return f2;
        }
        else{
            for (int i = 3; i <= n; i++){
                f0 = f1;
                f1 = f2;
                f2 = f0 + f1;
            }
            return f2;
        }
    }

    public static int[] SelectionSort(int... arrayToSort){
        for (int i = 0; i < arrayToSort.length-1; i++){
            int minIndex = i;

            for(int j = i+1; j < arrayToSort.length; j++){
                if (arrayToSort[j] < arrayToSort[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[minIndex];
                arrayToSort[minIndex] = temp;
            }
        }
        return arrayToSort;
    }

    public static int[] InsertionSort(int... arrayToSort){
        for (int i = 1; i < arrayToSort.length; i++){
            int currElem = arrayToSort[i];

            int k;
            for(k = i-1; k >=0 && arrayToSort[k] > currElem; k--){
                arrayToSort[k+1] = arrayToSort[k];
            }
            arrayToSort[k+1] = currElem;
        }
        return arrayToSort;
    }

    public static int[] BubbleSort(int... arrayToSort){
        // int noOfSwaps = 0;
        for (int i = arrayToSort.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arrayToSort[j] > arrayToSort[j+1]){
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j+1];
                    arrayToSort[j+1] = temp;
                    // noOfSwaps++;
                }
            }
        }
        // System.out.printf("%d\n", noOfSwaps);
        return arrayToSort;
    }

    public static int BinarySearch(int element, int... arrayToSearch){
        Arrays.sort(arrayToSearch);

        int len = arrayToSearch.length;
        int low = 0, high = len - 1;
        int mid = (low + high)/2;

        while (mid >= low){
            if (arrayToSearch[mid] < element){
                low = mid + 1;
            }
            else if (arrayToSearch[mid] > element){
                high = mid - 1;
            }
            else{
                return mid;
            }

            mid = (low + high)/2;
        }

        return -1;
    }

    /* public static int[] BubbleSort2(int... list) {
        boolean needNextPass = true;
        int noOfSwaps = 0;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    noOfSwaps++;
                    needNextPass = true;
                }
            }
        }
        System.out.printf("%d\n", noOfSwaps);
        return list;
    }*/

    }
