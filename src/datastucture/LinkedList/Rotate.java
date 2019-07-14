package datastucture.LinkedList;

/***
 *@ClassName Rotate
 *@Description
 * @author sukbear
 * @create 2019-04-22 18:44
 */
public class Rotate {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     *
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 1;
        ListNode cur = head, tail = null;
        //统计长度
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        //旋转的次数超过n取模
        k = k % len;
        tail = cur;
        //形成环
        tail.next = head;
        cur = head;
        int count = len - k;
        //头指针移动
        while (count > 0) {
            //尾指针指向头指针前一个元素
            tail = cur;
            cur = cur.next;
        }
        tail.next = null;
        return cur;
    }
}
