package com.dsa.array;

/*
Prob : Given an array of N integers arr[] where each element represents the max length of the jump that can be made
 forward from that element. Find the minimum number of jumps to reach the end of the array
 (starting from the first element). If an element is 0, then you cannot move through that element.

Note: Return -1 if you can't reach the end of the array.


Test Case: 1

Input:
N = 11
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3
Explanation:
First jump from 1st element to 2nd
element with value 3. Now, from here
we jump to 5th element with value 9,
and from here we will jump to the last.


Test Case: 2


Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2
Explanation:
First we jump from the 1st to 2nd element
and then jump to the last element.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ arri ≤ 107


 */


public class MinJumpToReachEndOfAnArray {

    public static void main(String[] args) {
        int[] arr ={3,4,2,1,2,1};
        System.out.println(minJumps(arr,6));
        System.out.println(minJumpsDP(arr, 6));
    }



    /*
         #Approach1: (recursive soln)
            i) Create a recursive function
            ii) In each recursive call get all the reachable nodes from that index.
            iii) Return the minimum no of jumps
            Time complexity - O()


       #Approach2( Dp solution)


     */

    public static int  minJumps(int[] arr, int n){


        //When nothing is reachable
        //from the given source

        if(n == 1){
            return 0;
        }

        // Traverse through all points
        //reachable from arr[l]. Recursively
        // get the minimum number of jumps
        //needed to reach arr[h] from these
        //reachable points.
        int res = Integer.MAX_VALUE;
        for(int i = 0;i <= (n-2);i++ ){
            if ((arr[i]+i) >= (n-1)){
               int sub_res = minJumps(arr, i+1);
               if (sub_res != Integer.MAX_VALUE){
                   res =Math.min(res,sub_res+1);
               }
            }
        }
        return res;
    }


    public static int minJumpsDP(int[] arr, int n){
        int dp[] = new int[n];

        dp[0] = 0;
        for (int i = 1;i<n;i++){
            dp[i] = Integer.MAX_VALUE;

            for(int j = 0; j<i; j++){
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }

            }

        }

        return dp[n-1];
    }



}
