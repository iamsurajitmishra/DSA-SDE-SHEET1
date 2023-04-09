package com.dsa.array;

import java.util.HashMap;

/*
Problem : Given an array of N integers, and an integer K, find the number of pairs of elements in the array
whose sum is equal to K.

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation:
arr[0] + arr[1] = 1 + 5 = 6
and arr[1] + arr[3] = 5 + 1 = 6.



Input:
N = 4, K = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation:
Each 1 will produce sum 2 with any 1.




 */



public class CountPairsWhoseSumK {

    public static void main(String[] args) {
        System.out.println(getPairsCount(new int[]{1, 5, 7, 1},4,6));
        System.out.println(getPairsCount1(new int[]{1,5,7,1},4,6));
    }

/*
#Approach 1: (Brute-force)

       =>Set up two pointer & compare the pairs

 */

   public static int countNoOfPairs(int[] arr, int n ,int k){
       if (arr.length == 0){
           return 0;
       }
       int len = arr.length;
       int count = 0;

       for (int i = 0;i<len; i++){
           for (int j = i+1;j<len;j++){
               if (arr[i]+arr[j] == k){
                   count++;
               }
           }
       }
       return (count-1); //As it also considering the pair (arr[i],arr[i]) whose sum equals to k..
   }






/*

#Approach 2: (Using Hashmap )


 */

   public static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        //Store counts of all elements
        for(int i = 0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i]) + 1);
        }


        for(int i = 0; i<n;i++){

            //// iterate through each element and increment the
            //// count (Notice that every pair is counted twice)
            if(map.containsKey(k-arr[i])){
                count+=map.get(k-arr[i]);
            }


            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if(k-arr[i] == arr[i]){
                count--;
            }

        }
        return (count/2);
    }

    /*

    #Approach3: (with single loop)

     Time complexity - O(N)
     Space Complexity - O(N)
     */
    static int getPairsCount1(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else {
                m.put(arr[i], 1);
            }
        }
        return count;
    }

}
