package com.dsa.array;

/*
Prob: Merge two sorted array without using extra space

PS: We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting)
are in the first array and the remaining numbers are in the second array.

Test Cases :
Input: ar1[] = {10}, ar2[] = {2, 3}
Output: ar1[] = {2}, ar2[] = {3, 10}

Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}



 */

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        merge(arr1,arr2, arr1.length, arr2.length);



        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }






/*
#Approach1:
    @Idea : Traversing two sorted array paralally

    Algo :
      => Set a pointer at the last element of arr1 => i
      => Set a pointer at the first element of arr2 => j
      => if(arr1[i] > arr2[j])
          => then swap(arr[i], arr[j]) & increment the 1st pointer and decrement the second pointer






 */

    public static void merge(int[] arr1, int[] arr2, int m, int n){

        int i = m-1, j = 0;

        while (i>=0 && j<n){
            if (arr1[i] > arr2[j]){
                swap(arr1, arr2, i, j);
            }
            i--;
            j++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);


    }

    private static void swap(int[] arr1, int[] arr2, int i, int j){
        int tmp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = tmp;
    }

}
