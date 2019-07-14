package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 16:01
 * <p>
 * <p>
 * 排序链表
 */
public class LinkedListDup {
  private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        while (p != null && q != null) {
            while (q != null && p.val == q.val) {
                //当p和下一个q相等时，往后移动q
                q = q.next;
            }
            p.next = q;
            p = q;
            if (p != null) {
                q = p.next;
            }

        }
        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     */
    public ListNode deleteDuplicatesTwo(ListNode head) {
        ListNode newHead = new ListNode(0);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = newHead;
        ListNode prev = head;
        while (head != null) {
            ListNode p = head;
            // 记录相同结点的个数
            int count = 0;
            while (p != null && p.val == head.val) {
                p = p.next;
                count++;
            }
            // 1 说明就一个
            if (count == 1) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            } else {
                head = p;
            }
        }
        // 断开后面的结点
        cur.next = null;
        return newHead.next;
    }
}
