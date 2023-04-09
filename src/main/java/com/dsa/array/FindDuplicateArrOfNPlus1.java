package com.dsa.array;
/*

Prob : Given an array of n + 1 integers between 1 and n, find one of the duplicates.
If there are multiple possible answers, return one of the duplicates.
If there is no duplicate, return -1.
Example:
Input: [1, 2, 2, 3]
Output: 2
Input: [3, 4, 1, 4, 1]
Output: 4 or 1


# Approach1 : (Brute-force soln)
    -> Time Complexity : O(N^2)
    -> Space Complexity : O(1)
# Approach2 : Using Count array [O(N)]
    -> Time Complexity : O(N)
    -> Space Complexity : O(N)

 */
public class FindDuplicateArrOfNPlus1 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3};
        System.out.println(findDuplicate(arr));
        System.out.println(getDuplicates(arr));
        System.out.println(getDuplicates1(arr));

    }




    /*
      Time Complexity : O(N^2)
     */
    public static  int findDuplicate(int[] arr){
        int len = arr.length;
        for (int i = 0;i<len;i++){
            for (int j = i+1;j<len;j++){
                if(arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }

        return -1;
    }

    /*
    #Approach2 : Count Array

            => Time Complexity : O(N)
            => Space Complexity : O(1)


     */


    public static int getDuplicates(int[] arr){
        if ( arr.length <= 1){
            return -1;
        }

        int n = arr.length;
        int count[] = new int[n-1];

        for (int i = 0;i<n;i++){
            count[arr[i]-1]++;
        }

        for (int i = 0;i<n;i++){
            if(count[i]>1){
                return arr[i];
            }
        }
        return -1;
    }


    /*
       # Approach3: (Sum of the elements)

       int arr[] = {}



     */

    public static int getDuplicates1(int[] arr){
        if (arr.length <= 0){
            return -1;
        }

        int len = arr.length; // (n+1) size

        int nsum = 0;
        int asum = 0;

        // Sum of n elements
        for (int i = 1;i<len;i++){
            nsum+=i;
        }

        // Sum of array elements
        for (int i = 0;i<len ;i++){
            asum += arr[i];
        }


        return (asum-nsum);
    }
}
