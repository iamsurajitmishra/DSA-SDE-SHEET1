package com.dsa.array;

import java.util.Arrays;

/*
Same as the Dutch-National-Flag Algo ---
 */
public class RearrangeArrPositiveAndNegativeElements {

    public static void main(String[] args) {

        int[] arr = {1,-2,4,-6};
        rearrange(arr);
        Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    }

    /*
       => Re-arrange positive and negative elements
       =>
     */

    public static void rearrange(int[] arr){

    int l = 0, r = arr.length-1;

    while(l<r){

        //If we find any positive element in the left side
        //increment the left pointer
        while(arr[l] > 0 ){
            l++;
        }

        //If we find negative element in the right side
        //decrement the right pointer
        while(arr[r]<0 ){
            r--;
        }

        //if (left<right) then swap
        if(l<r){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
    }
}
