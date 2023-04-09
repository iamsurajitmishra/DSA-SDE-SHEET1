package com.dsa.array;

/*
  Problem : Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number)
  which has the maximum sum and return its sum.

    Test Case1:
    Input:
    N = 5
    Arr[] = {1,2,3,-2,5}
    Output:
    9
    Explanation:
    Max subarray sum is 9
    of elements (1, 2, 3, -2, 5) which
    is a contiguous subarray.

    Time Complexity - O(N)

 */

/*
   => What is Kadane’s Algorithm?
   => Kadane’s algorithm is an iterative dynamic programming algorithm in which we search for a maximum sum
    contiguous subarray within a one-dimensional numeric array.
   => A simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array and keep track of the maximum sum
      contiguous subarray among all positive segments.
    => Working of Kadane's algorithm
        ->Let these two variables be max_ending_here and max_so_far, respectively.
        ->We will initialise both of them to 0.
        ->Each time we get a positive sum, we compare it with max_so_far and update max_so_far if it is greater than it.

 */


import java.util.Arrays;

public class KadanesAlgo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,-2,5};

        System.out.println(maxSumSubArr(arr)); // 9
    }


    // The Kadane's algo -
    public static int maxSumSubArr(int[] arr){
        if (arr.length == 0){
            return -1;
        }
        int len = arr.length;
        int cur = arr[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1;i<len;i++){
            cur = Math.max(cur+arr[i], arr[i] );
            max = Math.max(cur,max);
        }
        return  max;
    }


}
