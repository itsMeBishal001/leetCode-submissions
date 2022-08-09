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
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || head.next == null || k <= 1)
        return head;

    int len = length(head);
    ListNode curr = head, oh = null, ot = null;
    while (curr != null && len >= k)
    {
        int tempK = k;
        while (tempK-- > 0)
        {
            ListNode forw = curr.next;
            curr.next = null;
            addFirstNode(curr);
            curr = forw;
        }

        if (oh == null)
        {
            oh = th;
            ot = tt;
        }
        else
        {
            ot.next = th;
            ot = tt;
        }

        th = tt = null;
        len -= k;
    }

    ot.next = curr;

    return oh;
    }
    
    //////////////////
    int length(ListNode head)
{
    int len = 0;
    while (head != null)
    {
        head = head.next;
        len++;
    }
    return len;
}

ListNode th = null, tt = null;

 public void addFirstNode(ListNode node)
{
    if (th == null)
        th = tt = node;
    else
    {
        node.next = th;
        th = node;
    }
}
}