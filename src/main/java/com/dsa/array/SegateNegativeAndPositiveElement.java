package com.dsa.array;

import java.util.Arrays;

public class SegateNegativeAndPositiveElement {

    public static void main(String[] args) {
        int[] arr = {1,-5,6,-6,8,-10};

        segateNegativePositiveElements(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void segateNegativePositiveElements(int[] arr){
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            //if we see negative element on the left side
            //increment the left pointer
            while(arr[l] < 0 && (l<r)){
                l++;
            }

            //if we see positive element on the right side
            //decrement the right pointer

            while(arr[r] > 0 && (l<r)){
                r--;
            }

            if (l<r){
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }

        }



    }







}
