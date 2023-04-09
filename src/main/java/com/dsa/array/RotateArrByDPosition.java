package com.dsa.array;
/*

Prob: Rotate an array anti-clockwise d position
  Algo :



 */
import java.util.Arrays;

public class RotateArrByDPosition {
    public static void main(String[] args) {
         int[] arr = {1,2,3,4,5,6};

         rotateArrByDPosition(arr,2);
         System.out.println(Arrays.toString(arr));

        rotateArrByD(arr,2);
        System.out.println(Arrays.toString(arr));


    }

    /*
    #Approach3:
    1. Reverse K size sub-array.
    2. Reverse (N-K) size sub-array.
    3. Reverse N size array.

 Time Complexity : O(k+(N-K)+N) => O(2N) => O(N)
 Space Complexity : O(1)

     */
    public static void rotateArrByD(int[] arr, int d){

        int len = arr.length - 1;

        // reverse K size [0..d]
        reverse(arr,0,d-1);

        // reverse (N-K) size [d..N]
        reverse(arr, d, len);

        // reverse the whole array
        reverse(arr,0,len);
    }

    //reverse method
    private static void reverse(int[] arr , int l, int r){
        while(l<=r){
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

    }


    /*
    #Approach2:




     */

    public static void rotateArrAntiClockwiseByDPosition(int[] arr){

    }


    /*
    # Approach1: (Naive)
      1. create method of left rotate by 1 and then run it d time
      Time Complexity : O(N*d) [where N is the size of array
                               & d is the number of rotation
                               ]
      Space Complexity : O(1)

     */


    public static void rotateArrByDPosition(int[] arr, int d){
        for (int i = 0;i<d;i++){
            leftRotateByOne(arr);
        }
    }


    private static void leftRotateByOne(int[] arr){
        int temp = arr[0];
        int size = arr.length;
        for (int i = 1;i<size;i++){
            arr[i-1] = arr[i];
        }

        arr[size-1] = temp;
    }

}
