package com.dsa.array;
/*

Problem : Given an array arr[] of N non-negative integers representing the height of blocks.
If width of each block is 1,compute how much water can be trapped between the blocks during the rainy season.


input:
a1[] = {11, 1, 13, 21, 3, 7}
a2[] = {11, 3, 7, 1}
Output:
Yes
Explanation:
a2[] is a subset of a1[]
 */
public class TrappingRainWaterProblem {


    public static void main(String[] args) {

    }

    static long trappingWater(int arr[], int n) {
        long res = 0;
        long lmax[] = new long[n];
        long rmax[] = new long[n];

        //Find the left side max height
        lmax[0] = arr[0];
        for(int i = 1; i<n; i++){
            lmax[i] = Math.max(lmax[i-1],arr[i] );

        }

        //Find the right side max height
        rmax[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }

        //Calculate water level
        for(int i = 0;i<n;i++){
            res += (Math.min(lmax[i],rmax[i]) - arr[i]);
        }

        return res;

    }

}
