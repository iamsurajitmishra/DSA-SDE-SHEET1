package com.dsa.array;

public class FindMaximumProductSubArray {

    public static void main(String[] args) {

        int[] arr = {6, -3, -10, 0, 2};

        System.out.println(maxProduct(arr,arr.length));
    }


    public static long maxProduct(int[] arr, int n) {

        long curSubArrProduct = 1;
        long maxSubArrProduct = Long.MIN_VALUE;

        // L -> R
        for(int i = 0;i<n;i++){

            curSubArrProduct *= arr[i];

            maxSubArrProduct = Long.max(maxSubArrProduct, curSubArrProduct);

            if(curSubArrProduct == 0){
                curSubArrProduct = 1;
            }

        }



        curSubArrProduct = 1;

        /*
           => We need to traverse from the right for below type test cases -

           input : arr[] = {-8,2,3,5}
            As we can see if we only traverse from the right side then only,
            product = 5*3*2 = 30

         */


        //R -> L

        for(int i = (n-1); i>=0; i--) {
            curSubArrProduct *= arr[i];

            maxSubArrProduct = Long.max(maxSubArrProduct, curSubArrProduct);

            if (curSubArrProduct == 0) {
                curSubArrProduct = 1;
            }
        }
        return maxSubArrProduct;

    }


}
