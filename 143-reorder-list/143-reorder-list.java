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
    public void reorderList(ListNode head) {
        // if(head==null ||head.next==null)return head;
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        nhead=reverse(nhead);
        ListNode c1=head,c2=nhead;
        while(c2!=null){
               ListNode f1 = c1.next, f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }
    public ListNode midNode(ListNode head){
        if(head==null ||head.next==null)return head;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
      if(head==null ||head.next==null)return head;
        //head we will take 3 pointer .. current && previous && forword
        
        ListNode dummy =new ListNode(-1),prev=dummy,curr=head,forw=head;
        while(curr!=null){
            forw=forw.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        head.next=null;
        return prev;
    }
}