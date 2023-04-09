package com.dsa.linkedlist;

public class RemoveDuplicatesInSortedLoop {

    public static void main(String[] args) {
        LNode head = null;
        LList list = new LList(head);

        list.push(10);
        list.push(20);
        list.push(20);
        list.push(40);
        list.push(40);
        removeDuplicateInSortedArr(list.getHead());
        list.printList(list.getHead());
    }


    private static void removeDuplicateInSortedArr(LNode head){
       if(head == null) {
           return;
       }

       LNode tmp = head;
        while(tmp!= null && tmp.next!=null){

            if (tmp.data == tmp.next.data){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }
    }


}
