package jianzhioffer.fifty;

/***
 *@ClassName FindFirstCommonNode
 *@Description
 * @author sukbear
 * @create 2019-03-02 17:41
 *
 *
 *
 * 输入两个单向链表，找出它们的第一个公共结点。
 */

public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
    static ListNode findNode(ListNode head1, ListNode head2) {
        int len1 = getListLength(head1);
        int len2 = getListLength(head2);
        ListNode longListNode = null;
        ListNode shortListNode = null;
        int dif = 0;
        if (len1 > len2) {
            longListNode = head1;
            shortListNode = head2;
            dif = len1 - len2;
        } else {
            longListNode = head2;
            shortListNode = head1;
            dif = len2 - len1;
        }
        for (int i = 0; i < dif; i++) {
            longListNode = longListNode.next;
        }
        while (longListNode != null && shortListNode != null
                && longListNode != shortListNode) {
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return longListNode;
    }


    private static int getListLength(ListNode head1) {
        int result = 0;
        if (head1 == null) {
            return result;
        }
        ListNode point = head1;
        while (point != null) {
            point = point.next;
            result++;
        }
        return result;
    }

    class ListNode {
        String data;
        ListNode next;

        public ListNode(String data) {
            this.data = data;
        }
    }
}
