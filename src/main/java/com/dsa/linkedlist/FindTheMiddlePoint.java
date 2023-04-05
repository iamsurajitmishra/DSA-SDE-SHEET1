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


        list.printList(list.getHead());


    }

}
