package com.dsa.linkedlist;

public class MoveTheLastElementToFront {

    public static void main(String[] args) {
        LList list = new LList(null);
        list.push(10);list.push(20);
        list.push(30);list.push(40);


        list.printList(list.getHead());
        list.setHead(moveTheLastToFront(list.getHead()));
        list.printList(list.getHead());

    }

    private static LNode moveTheLastToFront(LNode head){

        LNode slast = null, last = head;
        if (head == null || head.next == null){
            return null;
        }

        while (last.next != null){
            slast = last;
            last = last.next;
        }

        slast.next = null;
        last.next = head;
        head = last;
        return head;
    }


}
