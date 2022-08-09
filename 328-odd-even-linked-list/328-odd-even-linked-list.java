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
    public ListNode oddEvenList(ListNode head) {
        if(head ==null ||head.next==null)
            return head;
        ListNode even=new ListNode(-1);
        ListNode odd=new ListNode(-1);
        ListNode ep=even,op=odd,curr=head;
        int count=1;
        while(curr!=null){
            if(count%2==0)
               {
                   ep.next=curr;
                ep=ep.next;
               }  else{
                op.next=curr;
                op=op.next;
            }
            count++;
            curr=curr.next;
    }
        ep.next=null;
        op.next=null;
        op.next=even.next;
        
        return odd.next;
}}