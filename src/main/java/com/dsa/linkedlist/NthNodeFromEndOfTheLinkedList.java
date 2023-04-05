package com.dsa.linkedlist;

public class NthNodeFromEndOfTheLinkedList {

    public static void main(String[] args) {
        LNode head = null;
        int n = 3;
        LList list = new LList(head);

        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        System.out.println("Actual List: ");
        list.printList(list.getHead());

        System.out.println(getNthNode(list.getHead(),3).data);
        System.out.println(getNthNode1(list.getHead(), 3).data);

    }


    // # Naive Approach
    // 1.Find the length of the LL.
    // 2. Find the (len - n + 1)th node
    private static LNode getNthNode(LNode head, int n){
        LNode tmp = head,tmp1 = head;;

        if (head == null){
            return null;
        }
        int len = 0;
        while(tmp != null){
            len++;
            tmp = tmp.next;
        }

        if (n > len){
            return null;
        }

        for(int i = 1; i<(len - n + 1); i++){
            tmp1 = tmp1.next;
        }

        return tmp1;
    }


    // using Two pointer approach
    private static LNode getNthNode1(LNode head, int n){
        LNode slow = head,fast = head;

        //Move the slow pointer to N distance
        for (int i = 0;i<n;i++){
            fast = fast.next;
        }

        // until fast != null - we will move each pointer by 1
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        // Now slow pointer is pointing to the Nth node from the end

        return slow;

    }




}
