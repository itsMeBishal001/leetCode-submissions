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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         if(l1==null || l2 ==null)
//             return l1!=null ?l1 :l2;
        
//         ListNode dummy=new ListNode(-1);
//         ListNode pre=dummy;
//         int carry=0;
//         while(l1!=null ||l2!=null||carry !=0){
//             int digit=(l1!=null? l1.val:0) +(l2 !=null ?l2.val:0)+carry;
            
//             carry=digit%10;
//             pre.next=new ListNode(digit/10);
//             pre=pre.next;
//             if (l1 != null)
//                 l1 = l1.next;
//             if (l2 != null)
//                 l2 = l2.next;
//         }
//         return reverse(dummy.next);
        
        
        
         if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode dummy = new ListNode(-1), prev = dummy, c1 = l1, c2 = l2;
        int carry = 0;

        while (c1 != null || c2 != null || carry != 0) {
            int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
            carry = sum / 10;

            prev.next = new ListNode(sum % 10);
            prev = prev.next;

            if (c1 != null)
                c1 = c1.next;
            if (c2 != null)
                c2 = c2.next;
        }

        return (dummy.next);
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