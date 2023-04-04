package com.dsa.linkedlist;

public class LList {

   public LNode head ;

   public LList(LNode head){
       this.head = head;
   }
    public void printList(LNode head){
        LNode tmp = head;
        while (tmp != null){
            System.out.print( tmp.data +"-> ");
            tmp = tmp.next;
        }
        System.out.println("NULL");
    }

    // Get the current head --
    public LNode getHead(){
       return this.head;
    }


    // Add node at the end of the linked list
    public void push(int data){
        LNode  newNode = new LNode(data);
        LNode tmp = null;
        LNode prev = null;

        // If the list is empty
        if (head == null){
            head = newNode;
        }else if(head.next == null){
            head.next = newNode;

        } else {
            tmp = head;
            // if the list is not empty
            while (tmp != null) {
                prev = tmp;
                tmp = tmp.next;
            }
            prev.next = newNode;
        }
    }

    public static void main(String[] args) {
        LNode head = null;
        LList ll = new LList(head);
        ll.push(10); ll.push(20);ll.push(30);ll.push(40);
        ll.printList(ll.getHead());
    }

}
