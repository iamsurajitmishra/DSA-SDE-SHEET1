package com.dsa.linkedlist;
/*

Problem : Given a linked list, write a function to reverse every
k nodes (where k is an input to the function).



Input: 1->2->3->4->5->6->7->8->NULL, K = 3
Output: 3->2->1->6->5->4->8->7->NULL
Input: 1->2->3->4->5->6->7->8->NULL, K = 5
Output: 5->4->3->2->1->8->7->6->NULL



 */
public class ReverseLinkedListInGroup {

    public static void main(String[] args) {
        LList list = new LList(null);

        list.push(10);list.push(20);
        list.push(30);list.push(40);

        list.printList(list.getHead());


        //Reverse in grp
        list.setHead(reverseInGrp(list.getHead(), 2));
        list.printList(list.getHead());

    }

    private static LNode reverseInGrp(LNode head, int k){

        LNode tmp = head, next = null, current = head, prev = null;
        int count = 0;
        while (current != null && count < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            count++;
        }

        // Now next pointer will point to the (k+1)th node
        if  (next != null)
        {
            head.next = reverseInGrp(next, k);
        }
        return prev;
    }

}
