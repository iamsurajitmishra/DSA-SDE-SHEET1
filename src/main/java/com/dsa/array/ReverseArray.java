package com.dsa.array;

import java.util.Arrays;

public class ReverseArray {


    /*
        Time complexity : O(N)
     */
    public static void reverseArray(int[] arr){
        int len = arr.length;
        for (int i = 0,j = len-1 ; i<=len-1 && j>=0;i++,j--){
            swap(arr,i,j);
        }
    }

    public static void swap(int[] arr, int l,int r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        swap(arr, 0, 3);
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}
