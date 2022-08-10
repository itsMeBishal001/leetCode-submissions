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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right)return head;
        
        ListNode curr=head,leftNode=null,rightNode=null,prev=head;
        int count=1;
        while(curr!=null){
            if(left==count){
                leftNode=curr;
            }else if(right==count){
                rightNode=curr;
                break;
            }
            if(leftNode==null){
                prev=curr;
            }
            curr=curr.next;
            count++;
        }
        if(leftNode==null||rightNode==null)return head;
        if(leftNode==head){
        ListNode ntail=rightNode.next;
        rightNode.next=null;
        ListNode nhead=reverse(leftNode);
            leftNode.next=ntail;
            return nhead;
        }
        ListNode ntail=rightNode.next;
        rightNode.next=null;
         ListNode nhead=reverse(leftNode);
        
        //join
        prev.next=nhead;
        
        leftNode.next=ntail;
        return head;
    }
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        return prev;
    }
}