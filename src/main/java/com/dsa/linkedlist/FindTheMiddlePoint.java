package com.dsa.linkedlist;

public class FindTheMiddlePoint {

    public static void main(String[] args) {
        LNode head = null;
        LList list = new LList(head);

        //add elements to list
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);

        list.printList(list.getHead());
        System.out.println("Node in the middle -");
        System.out.println(getMiddlePoint(list.getHead()).data);
        System.out.println(getMiddlePoint1(list.getHead()).data);
    }

    //Naive approach -
    /*
     Algo :
        1. Count the number of nodes in the list.
        2. get the middle node by
            a.(len/2) for even length
            b. (len/2)+1 for odd length
       # We are traversing the list twice .
     */
    private static LNode getMiddlePoint(LNode head){
        LNode tmp = head;
        LNode current = head, prev = current;
        int len = 0;
        int middle = 0;
        while (tmp != null){
            len++;
            tmp = tmp.next;
        }

        if (len % 2 == 0){
            middle = (len/2);
        }else{
            middle = (len/2)+1;
        }

        for (int i = 0; i<middle;i++){
            prev = current;
            current = current.next;
        }

        return prev;
    }

    //Using two pointer -
    /*
      We are traversing the list only once .


     */
    private static LNode getMiddlePoint1(LNode head){
        LNode p1 = head, p2 = head.next;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }



}
