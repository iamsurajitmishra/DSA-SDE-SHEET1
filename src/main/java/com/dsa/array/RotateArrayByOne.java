package com.dsa.array;

/*
   Prob : Rotate an array by one anti-clockwise/ left-rotate
     I/P : arr1[] = {1,2,3,4,5}
     O/P : arr1[] = {5,1,2,3,4}

 */


import java.util.Arrays;

public class RotateArrayByOne {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateArrByOne(arr);
        System.out.println(Arrays.toString(arr));
    }





    /*
     # Approach1:
       1. Store the last index value in a temp var.
       2. move all the elemnt by one
       3. assign temp value in arr[0] position

       Time complexity : O(N)
       Space complexity : O(1)


     */

    //a[] = {1,2,3,4,5}
    public static void rotateArrByOne(int[] arr){
        int size = arr.length;
        int temp = arr[0]; // temp = 1

        for (int i = 1;i<size;i++){
            arr[i-1]= arr[i];
        } // a[] = {2,3,4,5,5}

        arr[size-1] = temp;
    }


}
