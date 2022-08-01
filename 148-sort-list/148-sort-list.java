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
    
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null)
            return head;

        ListNode mid = middleNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        return mergeTwoLists(sortList(head), sortList(nHead));
    }
     public ListNode middleNode(ListNode head) {
      if(head==null||head.next==null)return head;
        ListNode slow=head,fast=head;
        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null||list2==null)
            return list1!=null ? list1 :list2;
        ListNode dummy =new ListNode(-1);
        ListNode prev=dummy,c1=list1,c2=list2;
        while(c1!=null && c2!=null){
            if(c1.val<=c2.val){
                prev.next=c1;
                c1=c1.next;
            }else{
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }
        prev.next =c1!=null ?c1:c2;
        return dummy.next;
    }
}