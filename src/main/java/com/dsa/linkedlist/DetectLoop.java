package com.dsa.linkedlist;

import java.util.HashSet;

public class DetectLoop {

    public static void main(String[] args) {
      LNode head = null;
      LNode first = new LNode(10);
      head = first;

        LNode second = new LNode(20);
        head.next = second;

        LNode third = new LNode(30);
        second.next = third;

        //Loop created
       third.next = second;

        System.out.println(isLoopDetected(head));
        System.out.println(isLoopDetected1(head));
        System.out.println(isLoopDetected2(head));
    }



    // Approach 1: (Hashing)
    /*
        Algo :
          1. Take a hashset - Set<LNode>
          2. Traverse the LL and store each node into the hash Set and check if any node already visited
               a. if visited - loop detected
               b. else - loop not detected

        Time complexity : O(N)
        Space Complexity : O(N) [Auxilary space used by HashSet]
     */
   private static boolean isLoopDetected(LNode head){

       if (head == null){
           return false;
       }

       HashSet<LNode> set = new HashSet<>();
       LNode curr = head;
       // traverse the list
       while (curr != null){

           //if visited - loop detected
           if (set.contains(curr)){
               return true;
           }

           set.add(curr);
           curr = curr.next;
       }

    return false;

   }

    // Approach 2: (Floyed algo)
    private static boolean isLoopDetected1(LNode head){
       LNode slow = head , fast = head;
       //base case
       if(head == null){
           return false;
       }
        //Move slow ptr at x speed and fast ptr at 2x speed
       while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;

           if (fast == slow){
               return true;
           }
       }
       return false;
    }


    //Approach 3: (Using visited marker)
    private static boolean isLoopDetected2(LNode head){

       LNode tmp = head;
       while (tmp != null){
           if (tmp.isVisited){
               return  true;
           }
        tmp.isVisited = true;
        tmp = tmp.next;

       }
        return false;
    }


}
