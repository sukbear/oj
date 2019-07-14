package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 22:26
 *
 *
 * 请判断一个链表是否为回文链表。
 * 其一，find mid node 使用快慢指针找到链表中点。
 * 其二，reverse 逆序后半部分。
 * 其三，check 从头、中点，开始比较是否相同。
 */
public class PalindromeList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    /**链表逆置递归算法*/
    public ListNode reverse(ListNode head){
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        //先反转后面的链表，走到链表的末端结点
        ListNode newHead = reverse(head.next);
        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverse1(ListNode head){
        //定义三个指针，保存原来的连接的状态
        //当前状态
        ListNode p = head;
        //前驱指针和后记指针，尾指针用于返回链表，全部置空
        ListNode pre=null,pnext = null,tail=null;
        //开始遍历
        while(p!=null){
            //如果当前结点不是 null，那么初始化 pnext 指针指向当前结点的下一个结点
            pnext = p.next;
            //pnext==null ,则p为最后一个节点，赋值给尾指针
            if(pnext==null){tail = p;}
            //进行链表的反转，当前结点的 next 指针指向前一个结点，实现链表方向的反转，此时发生了断链
            p.next = pre;
            //使用 pre 指针保存状态，pre 等价于是后移一个结点
            pre = p;
            //p后移
            p = pnext;
        }
        return tail;
    }


    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 根据快慢指针，找到链表的中点,链表元素为偶数的话，找到第一个，要找第二个则有while(fast!=null&&fast.next!=null)
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow!=null){
            if(head.val!=slow.val){return false;}
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
