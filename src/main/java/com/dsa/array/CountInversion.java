package com.dsa.array;
/*
Prob: Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then
the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


Test case1:
Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).


 */
public class CountInversion {


    public static void main(String[] args) {

        int [] arr = {2, 4, 1, 3, 5};

        long ans = countInversion(arr, 0, arr.length-1);
        System.out.println(ans);
    }


    /*

    Time complexity - O(N*Log(N))
    Space Complexity - O(M+N)


     */
    public static long countInversion(int[] arr, int l,int r){

        if (l<r){
          long  res = 0;
            //Find the middle point
            int m = l+(r-l)/2;

            // sort the left half
            res += countInversion(arr, l, m);
            //sort the right half
            res += countInversion(arr, m+1, r);

            //merge the left and the right sub array
            res += countAndMerge(arr, l , m , r);
            return  res;
        }
        return 0;
    }

    private static long countAndMerge(int[] arr,int l, int m, int r){

        // compute the size
        int n1 = (m-l)+1;
        int n2 = (r-m);

        //declare the temp array
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy elements of the left array
        for (int i = 0; i<n1;i++){
            L[i] = arr[l+i];
        }

        //copy the element of the right array
        for(int j = 0;j<n2;j++){
            R[j] = arr[m+1+j];
        }


        int i=0, j=0,k = l;
        int res = 0;
        //sort & merge
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k++] = L[i++];
            }else{
                arr[k++] = R[j++];

                /*
                   As already the left and right array are sorted so the remaining element that
                   are not sorted is -
                 */

                res = (n1 - i);

            }
        }

        //Remaining elemnts of Left array

        while(i<n1)
        {
            arr[k++] = L[i++];
        }

        // Remaining elements of Right array

        while(j<n2){
            arr[k++] = R[j++];
        }

        return res;
    }
}
