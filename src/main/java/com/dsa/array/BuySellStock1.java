package com.dsa.array;
/*
Problem : [At most 1 transaction allowed]


Test Case 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Test Case 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

 */
public class BuySellStock1 {

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};

        System.out.println(getMaxProfit(arr));
    }





    /*
          idea - To track the min price
     */
    public static int getMaxProfit(int[] prices){
        if (prices.length == 0){
            return 0;
        }

        int n = prices.length;
        int buy = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1;i<n; i++){
            // If we found any price that is lesser than previous buy price
            if (buy>prices[i]){
                buy = prices[i];
            }else {
                // If any price incremented
                maxProfit = Integer.max(maxProfit, (prices[i] - buy));
            }
        }
        return maxProfit;
    }



}
