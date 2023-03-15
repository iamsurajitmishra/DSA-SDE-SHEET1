package com.dsa.array;

/*

Problem : Reverse Array


 */


import java.util.Arrays;

public class ReverseArray {


    public static void main(String[] args) {

        int[] arr = new int[]{10,50,30,60,40};
        reverse(arr);

        System.out.println(Arrays.toString(arr));

    }

    /*
      # Two Pointer approach -

     */
    public static void reverse(int[] arr){
        int l = 0, r = arr.length - 1 ;
        while(l<=r){

            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            l++; r--;
        }
    }




}
