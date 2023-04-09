package com.dsa.linkedlist;

public class AddOneToANumber {

    public static void main(String[] args) {
        LList list = new LList(null);
        list.push(1);list.push(9);list.push(9);list.push(9);
        System.out.println("Before adding 1 to it.");

        list.printList(list.getHead());
        list.setHead(addOne(list.getHead()));

        System.out.println("After adding 1 to it");
        list.printList(list.getHead());


    }


    private static LNode addOne(LNode head){

        if (head == null){
            return null;
        }

        //reverse the list
        head = reverse(head);

        // add 1 to the list
        head = addOneUtil(head);

        return reverse(head);
    }


    private static LNode reverse(LNode head){
        LNode prev = null;
        LNode current = head;
        LNode next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static LNode addOneUtil(LNode head){
        LNode res = head, prev = null;

        int carry = 1, sum = 0;

        while (head != null){
            sum = head.data + carry;
            carry = (sum >= 10)? 1 : 0;
            //update sum if it is greater than 10
            sum = sum % 10;

            // create a new node with sum data
            head.data = sum;

            prev = head;
            head = head.next;
        }

        if(carry > 0){
            prev.next = new LNode(carry);
        }

        return  res;
    }


}
