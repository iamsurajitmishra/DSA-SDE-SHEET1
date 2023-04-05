package com.dsa.linkedlist;

public class DetectAndRemoveLoop {



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


        //detect and remove loop
       detectAndRemoveLoop(head);

        LList list = new LList(head);
        list.printList(list.getHead());
    }



    private static void detectAndRemoveLoop(LNode head){
        LNode slow = head, fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //If loop detected
            if (slow == fast){
                //remove the loop
                removeLoop(slow, head);
            }
        }

    }


    private static void removeLoop(LNode loop, LNode head){
        LNode p1 = loop, p2 = loop;
        LNode prevNode = p1;


        while (p1.next != p2){
            prevNode = p1;
            p1 = p1.next;
        }
        prevNode.next = null;

    }


}
