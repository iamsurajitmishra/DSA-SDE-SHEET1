package com.dsa.array;

/*
Prob : Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each
tower either by increasing or decreasing them by K only once.
Find out what could be the possible minimum difference of the height of shortest and longest towers after you have
modified each tower.

Note: Assume that height of the tower can be negative.


Test Case1-

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as
{3, 3, 6, 8}. The difference between
the largest and the smallest is 8-3 = 5.


Test Case2-
Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{6, 12, 9, 13, 17}. The difference between
the largest and the smallest is 17-6 = 11.



 */


import java.util.Arrays;

public class MinimizeHeights1 {

    public static void main(String[] args) {
        int[] arr ={1, 5, 8, 10};
        int k = 2,n = 4;
        getMinDiff(arr,4,2);
        System.out.println(getMinDiff(arr,4,2));
    }

    /*
       Idea: We have a sorted arr[] = {a,c,d,b} , k is a constant
        min = a, max = b, diff = (b-a)


        //for the sake of simplicity let's ignore the remaining element
        Obs1: If we increment all by k,
              diff = (b+k)-(a+k) = (b-a)

    Time Complexity : O(N * Log(N)) + O(N) = O(N * Log(N))
    Space Complexity : O(N)

     */


    public static int getMinDiff(int[] arr, int n, int k) {
        //sort
        Arrays.sort(arr);

        int len = arr.length;
        int max = arr[len-1];
        int min = arr[0];

        int diff = (max-min);

        for(int i = 1;i<len;i++){
            min = Math.min(arr[0]+k,arr[i]-k);
            max = Math.max(arr[i-1]+k, arr[len-1]-k);
            diff = Math.min(diff,(max-min));
        }

        return diff;
    }

}
