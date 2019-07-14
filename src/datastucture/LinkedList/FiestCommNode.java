package datastucture.LinkedList;

/***
 *@ClassName FiestCommNode
 *@Description
 * @author sukbear
 * @create 2019-05-22 19:58
 */
public class FiestCommNode {
    /**
     * a+c+b=b+c+a;
     * 环
     *
     * */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
