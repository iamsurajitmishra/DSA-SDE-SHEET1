package com.dsa.array;

import java.util.Arrays;

public class FindMaxMinElement {


    public static void main(String[] args) {
        int[] arr = {1,5,8,3,6};
        //using bruteforce method
        System.out.println(getMaxElement(arr));
        System.out.println(getMinElement(arr));

        //using the sorting method
        System.out.println(findMaxElement(arr));
        System.out.println(findMinElement(arr));
    }

    /*
       Prob: Find the max element in an array
       Time complexity : O(N)
     */
    public static int getMaxElement(int []arr){

        int max = Integer.MIN_VALUE;
        int len = arr.length;
        for (int i = 0;i<len;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    /*
       Prob: Find min element in an array
       TC -> O(N)
     */
    public static int getMinElement(int[] arr){
        int min = Integer.MAX_VALUE;
        int len = arr.length;

        for (int i=0;i<len;i++){
            if(arr[i]<min){
               min = arr[i];
            }
        }
        return min;
    }

    /*
       # Approach 2: Sorting(arr) [ascending order]
        1-> sort(arr)
             -> findMax(arr)-> return arr[last_index]
             -> findMin(arr)-> return arr[first_index]
       Time Complexity - O(nlogn)
     */

    public static int findMaxElement(int arr[]){
        //sort the arr
        Arrays.sort(arr);

        //return the last_index
        return  arr[arr.length-1];
    }

    public static int findMinElement(int arr[]){
        //sort the arr
        Arrays.sort(arr);
        //return the first index
        return arr[0];
    }

}
