package com.dsa.array;
/*

Merge Sort algorithm :

    -> Find the middle point
    -> sort the left subarray
    -> sort the right subarray
    -> merge two sorted array



    TC1:
        I/P : arr[] = {38,27,43,3,9,82,10}
        O/P : arr[] = {3,9,10,27,38,43,82}

 */


import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {38,27,43,3,9,82,10};

        merge_sort(arr, 0,arr.length-1);

        Arrays.stream(arr).forEach(e-> System.out.print(e +" "));

    }

    // Implement merge sort


    public static void merge_sort(int[] arr, int l, int r){

        if(l<r){

            //Find the middle point
            int m = l + ((r - l) / 2);
            //sorting of left sub array
            merge_sort(arr, l, m);
            //sorting of right sub array
            merge_sort(arr, m + 1, r);
            //merge
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r){

        //Compute the size of the temp array
        int n1 = (m - l) + 1;
        int n2 = (r-m);

        //Declare two temp array
        int[] L = new int[n1];
        int[] R = new int[n2];


        //Fill the left array
        for (int i = 0;i<n1;i++){
            L[i] = arr[l+i];
        }

        //Fill the right array
        for (int j = 0;j<n2;j++){
            R[j] = arr[m+1+j];
        }

        //Merging & Sorting
        int i = 0 , j = 0 , k = l;
        while(i<n1 && j<n2){
            if (L[i] < R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Remaining element in left array
        while(i<n1){
            arr[k] = L[i];
            k++;
            i++;
        }

        //Remaining elemnt in right array
        while(j<n2){
            arr[k] = R[j];
            k++;
            j++;
        }
    }
}
