package com.dsa.linkedlist;

import com.dsa.linkedlist.LList;
/*
 * Reverse a Linked List -
 *
 * I/P : 1-> 2 -> 3 -> 4 -> NULL
 * O/P : 4 -> 3 -> 2 -> 1 -> NULL
 *
 * */
public class ReverseList {

    public static void main(String[] args) {
        LNode head = null;
        LList list = new LList(head);
        list.push(10);list.push(20);
        list.push(30);
        //List before reversing the list
        System.out.println("Before reversing the linked list--");
        list.printList(list.getHead());
        //List after reversing the list
        System.out.println("After reversing the linked list--");
        LNode n = reverse(list.getHead());
        while(n != null){
            System.out.print(n.data+"->");
            n = n.next;
        }
        System.out.println("NULL");

    }

    /*
        # Approach 1: using 3  pointer
     */
    public static LNode reverse(LNode head){
        LNode prev = null;
        LNode current = head;
        LNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}