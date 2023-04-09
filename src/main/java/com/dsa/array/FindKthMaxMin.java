package com.dsa.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
  Prob : Find Kth max min element -

  #Approach 1: (sorting)
      1-> sort(arr) ascending order
      2-> return the kth min element
 */
public class FindKthMaxMin {

    public static void main(String[] args) {
        Integer[] arr= {5,15,10,20,8};
        int k = 3;
        System.out.println(findKthMinElement(arr,k));
        System.out.println(getKthMinElement(arr,k));
        System.out.println(getKthMinElement(arr, k));
    }


    /*
       TC -> O(nlog(n))
     */
    public static int findKthMinElement(Integer arr[], int k){
        int len = arr.length;
        //sort the array in asc
        Arrays.sort(arr);

        return (k-1< len)?arr[k-1]:-1;

    }

    /*

    #Approach2: (using Max heap)
    #Algo :
    1. Store (k+1) element in heap.
    2. check if heap.size() > k
        -> YES -> remove the max item from the heap
        -> No -> Ignore
    3. Finally return the peek or top item of the heap

    Time Complexity : As we are always maintaining the (k+1) size in heap => O(n*Log(k+1)) =~ O(n*LogK)
    Space Complexity : O(K+1)

     */

    public static int getKthMinElement(int arr[], int k){

        if (arr.length == 0 || arr.length < k){
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

        //Scan each element
        for (int i = 0;i<arr.length;i++){
            pq.add(arr[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }





    /*
       # Approach3 : using min heap
       #Algo :
       1 -> build a min heap of K size
       2 -> scan element from (k+1) index & compare with the top elemnt
            -> if current elemnt is smaller than the top elemnt
                 -> ignore
            -> if current element is greater than the top elemnt
               -> remove top element from min heap and insert the current elemnt

        TC -> O(K+(N-K)*Log(K)) < O(NLogN)
     */


    public static int getKthMinElement(Integer arr[], int k){
        //Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = arr.length;
        //build the min heap with k elemnt
        // TC -> O(K)
        for(int i = 0;i<k;i++){
            pq.add(arr[i]);
        }
        //O((n-k)*logk)
        for (int i= k;i<len;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

}
