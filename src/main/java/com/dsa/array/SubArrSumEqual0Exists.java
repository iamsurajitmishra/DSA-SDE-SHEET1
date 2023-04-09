package com.dsa.array;
/*
Prob : Given an array of positive and negative numbers.
Find if there is a subarray (of size at-least one) with 0 sum.


Input:
5
4 2 -3 1 6

Output:
Yes

Explanation:
2, -3, 1 is the subarray
with sum 0.


 */


import java.util.HashSet;

public class SubArrSumEqual0Exists {

/*

#Approach1:(brute-force)



 */



    /*

    #Approach2 :
        1. In a hash set we are gonna store each sum formed by adding the current element.
        2. if we find out any repetition then we know 0 sum exist. [As (n+0) = n]

        Time Complexity - O(N)
        Space Complexity - O(N) [To store all the sum we need a hash set]

     */
    static boolean findsum(int arr[],int n)
    {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for(int i = 0;i<n;i++){
            sum+=arr[i];

            if(sum == 0){
                return true;
            }

            if(set.contains(sum)){
                return true;
            }else{
                set.add(sum);
            }

        }

        return false;

    }




}
