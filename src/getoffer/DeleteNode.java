package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 21:27
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode("a");
        ListNode node2 = new ListNode("b");
        ListNode node3 = new ListNode("c");
        ListNode node4 = new ListNode("d");
        ListNode node5 = new ListNode("e");
        node1.setNext(node2);node2.setNext(node3);node3.setNext(node4);node4.setNext(node5);
        System.out.println(findDataFromTail(node1,4));
        System.out.println(findMid(node1).getData());
    }
    /**
     * 求链表的中间结点。如果链表中结点总数为奇数，
     * 返回中间结点；如果结点总数为偶数，返回中间两个结点的任意一个
     */
    private static ListNode findMid(ListNode head){
        ListNode slow = head,fast=head;
        if(head==null){return null;}
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    /**
     * 输入一个链表，输出该链表中倒数第 K 个结点。
     * 为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点。
     * 例如一个链表有 6 个结点，从头结点开始它们的值依次是 1,2,3,4,5,6。
     * 这个链表的倒数第 3 个结点是值为 4 的结点。
     * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于 k，输入的 k 参数为 0）
     */
    static String findDataFromTail(ListNode a, int k){
        if(a==null){return null;}
        if(k<=0){
            System.out.println("k is error");
            return null;
        }
        ListNode p = a;
        ListNode q = null;
        while(k-->1){
            if(p.next==null){
                System.out.println("k 不应该大于链表长度");
                return null;
            }
            p = p.next;
        }
        q = a;
        while(p.next!=null){
            p= p.next;
            q=q.next;
        }
        return q.getData();
    }
    /**
     * o(1)时间删除链表节点，考虑尾节点和头节点。
    *
    * */
    static void deleteNode(ListNode head,ListNode p){
        //删除节点时尾巴节点，遍历到尾节点的前一个节点，然后next=null
        if(p.next==null){
            while(head.next!=p){
                head = head.next;
            }
            head.next=null;
        }
        //删除为第一个节点
        if(head == p){
            /*if(head.next==null){head = null;}
            else{
                head = head.next;
            }*/
            head = null;
        }else{
            p.setData(p.getNext().getData());
            p.setNext(p.getNext().getNext());
        }
    }
   static class ListNode{
        ListNode next;
        String data;
        public ListNode() {
        }
        public ListNode(String data) {
            this.data = data;
        }
        public ListNode(ListNode next, String data) {
            this.next = next;
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
