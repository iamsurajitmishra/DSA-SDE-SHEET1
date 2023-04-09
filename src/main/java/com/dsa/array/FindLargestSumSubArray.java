package com.dsa.array;
/*
Prob : Find largest sum sub-array.

I/P : Arr[] = {1,2,3,-2,5}
O/P : 9

I/P : Arr[] = {-1,-2,-3,-4}
O/P : -1


 */
public class FindLargestSumSubArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};
        int ans = getSubArrSum(arr);
        System.out.println(ans);

        ans = maxSubArrSum(arr);
        System.out.println(ans);

    }



    /*
    #Approach: (Bruteforce)
     1. Find all the sub-array
     2. Get the sum of each sub-array
     3. Compare with the maximum


    Time Complexity = O(n^2)
    Space Complexity = O(n)
     */

    public static int getSubArrSum(int[] arr){
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<len;i++){
                int sum = 0;
            for (int j = i;j<len;j++){
                sum+=arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /*
       #Approach2 :
          Idea : Either we expand the subarray or we start new subarray.

     */

    public static int maxSubArrSum(int[] arr){
        int cur = arr[0];
        int res = arr[0];
        int len = arr.length;

        for (int i = 1;i<len;i++){
            cur = Math.max(cur+arr[i], arr[i]);
            res = Math.max(res, cur);
        }

        return res;
    }

}
