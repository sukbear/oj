package datastucture.LinkedList;

/***
 *@ClassName Partition
 *@Description
 * @author sukbear
 * @create 2019-04-23 17:42
 */
public class Partition {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode p = new ListNode(0), q = new ListNode(0), ph = p, qh = q, cur = head, next = cur.next;
        while (cur != null) {
            cur.next = null;
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        p.next = qh.next;
        return ph.next;
    }
}