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
    public ListNode mergeKLists(ListNode[] lists) {
        
        return mergeKLists_1(lists,0,lists.length-1);
    }
    
    
    public ListNode mergeKLists_1(ListNode[] lists,int si,int ei) {
        if(lists.length==0)return null;
        if(si==ei)
            return lists[si];
        int mid =(si+ei)/2;
        return mergeTwoLists(mergeKLists_1(lists,si,mid),mergeKLists_1(lists,mid+1,ei));
    }
    
    //////////
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
    ////////////
    // public ListNode tail(ListNode head){
    //     if(head==null || head.next==null){
    //         return head;
    //     }
    //     ListNode cur=head;
    //     while(cur.next!=null){
    //         cur=cur.next;
    //     }
    //     return cur;
    // }
}