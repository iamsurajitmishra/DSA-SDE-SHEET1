package com.dsa.array;

/*
Given an array arr[] of size N, the task is to print the lexicographically next greater permutation of the given array.
If there does not exist any greater permutation,
then print the lexicographically smallest permutation of the given array.

Test Case 1:
Input: N = 6, arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explanation: The next permutation of the given array is {1, 2, 4, 3, 5, 6}.


Test Case 2:
Input: N = 3, arr = {3, 2, 1}
Output: {1, 2, 3}
Explanation: As arr[] is the last permutation.
So, the next permutation is the lowest one.




 */


public class NextPermutation {

    public static void main(String[] args) {

    }

    /*
    #Approach1:
    Idea : Generate all the permutations of the array and then find the next greater.
    Time Complexity : O(n*(n!)) [As total number of permutation possible is n!]
    Space Complexity : O(N) [ To store all the permutation into some data structure]

     */

    /*
    #Approach2: [linear time solution]

    Algo:
     -> Find longest non-increasing suffix from end
     -> Find the pivot
     -> Find right most successor of pivot in the suffix
     -> Swap the pivot and right most successor
     -> Reverse the suffix

     */

    //Find the longest increasing suffix


}
