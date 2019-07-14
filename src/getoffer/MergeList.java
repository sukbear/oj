package getoffer;

/***
 *@ClassName MergeList
 *@Description
 * @author sukbear
 * @create 2019-03-03 17:23
 */
public class MergeList {
    /**
     * 递归 简单
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = null;
        if (list1.val < list2.val) {
            p = list1;
            p.next = Merge(list1.next,list2);
        } else {
            p = list2;
            p.next = Merge(list1,list2.next);
        }
        return p;
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode p = head1;
        ListNode q = head2;
        //临时头节点
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            //工作指针跟上
            cur = cur.next;
        }
        if(p!=null){
            cur.next = p;
        }
        if(q!=null){
            cur.next= q;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        a.next = b;
        b.next = c;
        d.next = e;
        merge(a, d);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
