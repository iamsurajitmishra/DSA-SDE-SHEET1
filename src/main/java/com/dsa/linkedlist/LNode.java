package com.dsa.linkedlist;

/*
   Linked List node structure -
 */
public class LNode {
    public int data;
    public  LNode next;

    public boolean isVisited;
    public LNode(int data){
        this.data = data;
        this.next = null;
        this.isVisited = false;
    }
}
