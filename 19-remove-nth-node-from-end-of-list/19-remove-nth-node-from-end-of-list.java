/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return head;
        
        ListNode a=head,b=head;
     
        while(n-->0){
            b=b.next;
        }
        if(b==null){
           // a=a.next.next;
            return head.next;
        }
        while(b.next!=null){
          
                a=a.next;
                b=b.next;
            
           
        }
        a.next=a.next.next;
        return head;
    }

}