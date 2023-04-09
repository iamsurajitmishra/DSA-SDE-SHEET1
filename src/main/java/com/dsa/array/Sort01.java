package com.dsa.array;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int arr[] = {0,1,0,1,0,1};
        sort01(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void sort01(int[] arr){
        int l = 0, r = arr.length -1;

        while(l<=r){
            while(arr[l] == 0 && (l<=r)){
                l++;
            }
            while(arr[r] == 1 && (l<=r)){
                r--;
            }

            if (l<=r){
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }

        }
    }
}
