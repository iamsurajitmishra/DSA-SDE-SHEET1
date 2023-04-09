package com.dsa.array;

import java.util.Arrays;

/*
   Prob : We are given an array with three types of elements & we need sort those elements.[We should not use any sorting algo]
   Algo : (Dutch-National-Flag-Algo / 3-Way quick sort)

        -> 1. (low..mid)
        ->2.mid
        ->3.(mid..hi)



 */
public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int[] arr){
        if(arr.length == 0){
            return;
        }
        int len = arr.length;
        int left = 0, mid = 0, right = len-1;

      while(mid<=right){
          switch (arr[mid]) {
              case 0:
                  int temp = arr[mid];
                  arr[mid] = arr[left];
                  arr[left] = temp;
                  left++;
                  mid++;
                  break;
              case 1:
                  mid++;
                  break;
              case 2:
                  int tmp = arr[mid];
                  arr[mid] = arr[right];
                  arr[right] = tmp;
                  right--;
          }
      }

    }
}
