package com.dsa.linkedlist;

public class FindLengthOfLoop {

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

        System.out.println("Size of the loop is "+getLoopLen(head));
    }

    private static int getLoopLen(LNode head){
        LNode slow = head, fast = head;
        int len = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //loop detected
            if (fast == slow){
                System.out.println("loop detected!!");
                LNode p1 = slow;
                LNode p2 = slow;
                LNode prev = p1;
                while (p1.next != p2){
                    len++;
                    prev = p1;
                    p1 = p1.next;
                }
                prev.next = null;
            }
        }

        return len;
    }


}
