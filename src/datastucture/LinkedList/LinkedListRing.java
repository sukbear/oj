package datastucture.LinkedList;

/***
 *@ClassName LinkedListRing
 *@Description
 * @author sukbear
 * @create 2019-04-18 15:22
 */
/*      1.给一个单链表，判断其中是否有环的存在;

        2.如果存在环，找出环的入口点;

        3.如果存在环，求出环上节点的个数;

        4.如果存在环，求出链表的长度;

        5.如果存在环，求出环上距离任意一个节点最远的点（对面节点）;
        从任意节点开始（当fast==node || fast.next==node）{s所指的就是对面节点}
        6.（扩展）如何判断两个无环链表是否相交;

        7.（扩展）如果相交，求出第一个相交的节点;
        将一个链表的头节点链到另一个链表的尾节点，求环的入口。。。
        */

public class LinkedListRing {
    /**
     * 给一个单链表，判断其中是否有环的存在;
     */
    public boolean haveRing(ListNode head) {
        ListNode slow = head, fast = head;
        //fast更快，如果无环更先到达尾节点，
        //当链表节点为偶数时，fast刚好到达尾部（fast!= null)的后一个（null）
        //当链表节点为奇数时，fast刚好到达尾部（fast.next != null)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2.如果存在环，找出环的入口点;
     * 起点到环入口距离为a,环的长度为r,环入口到相遇点的距离为x;
     * 设slow指针走了s步;
     * 2s = a+x+nr;
     * s = a+x;
     * a = kr +(r - x);
     * 当快慢指针相遇的时候，慢指针从头和快指针一起运动，相遇的点就是换的入口
     */
    public ListNode ringEnterNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        //链表无环，返回空
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 3.如果存在环，求出环上节点的个数;
     */
    int ringNodeNumber(ListNode head) {
        //先求出环的入口
        ListNode p = ringEnterNode(head);
        //无环长度为零
        if (p == null) {
            return 0;
        }
        ListNode q = p.next;
        int len = 1;
        while (p != q) {
            q = q.next;
            len++;
        }
        return len;
    }

    /**
     * 4.如果存在环，求出链表的长度;
     */
    public int listLength(ListNode head) {
        ListNode start = ringEnterNode(head);
        int len = 0;
        if (start == null) {
            //无环,直接计数
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        } else {
            //计数环前面的个数
            while (head != start) {
                len++;
                head = head.next;
            }
            //加上环的长度;
            return len + ringNodeNumber(head);
        }
    }
/**利用链表环的特点可以求两个相交链表的问题*/
ListNode intersectList(ListNode head1,ListNode head2){
    ListNode head = head1;
    while(head.next!=null){
        head=head.next;
    }
    head.next=head2;
    return ringEnterNode(head1);
}
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        h.next = i;
        i.next = d;
        LinkedListRing llr = new LinkedListRing();

     System.out.println(llr.intersectList(a,h).val);
    }
}
