/**
 * @author sukbear
 * @ClassName Main
 * @Description
 * @create 2019-09-25 20:56
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);
        l1.next=l2;l2.next=l3;l3.next=l4;
        l5.next=l6;l6.next=l7;
      Main obj = new Main();
        System.out.println(obj.add(l1,l5).toString());
    }
    ListNode add(ListNode l1, ListNode l2){
        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        ListNode res = reverse(addTwoNumbers(p1,p2));
        return res;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p =l1,q=l2,cur = newHead;
        int carry = 0;
        while(p!=null||q!=null){
            int x = p==null?0:p.val;
            int y = q==null?0:q.val;
            int sum = x+y+carry;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            p = p!=null?p.next:p;
            q = q!=null?q.next:q;
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return newHead.next;
    }

    ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode p = head;
        ListNode pre = null;
        ListNode temp = null;
        while(p!=null){
            temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }
}
class ListNode {
    int val;
    ListNode next;
     ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder();
        while(p!=null){
            sb.append(p.val);
            p=p.next;
        }
      return sb.toString();
    }
}
   /* ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    //carry 表示进位数
    int carry = 0;
        while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                //进位数
                carry = sum / 10;
                //新节点的数值为sum % 10
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
                }
                if (carry > 0) {
                curr.next = new ListNode(carry);
                }
                return dummyHead.next;*/