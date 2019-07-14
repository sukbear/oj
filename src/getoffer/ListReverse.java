package getoffer;

/**
 * @author sukbear
 * @create 2019-02-28 11:43
 */
/*链表反转*/
public class ListReverse {
    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        Node node = reverse(node1);
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    /**指针反转
     * pre cur=pre.next temp
     * while(cur!=null){
     *     temp = cur.next;
     *     cur.next = pre//反转;
     *     pre = cur; //移动
     *     cur = temp;//向前移动
     * }
     * head.next = null //第一个元素变成最后一个元素，next空
     * return pre
     * */
    public ListNode reverse2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }else{
            ListNode newHead = reverse2(head.next);
            //将当前节点设置为后面节点的后续节点,反转操作
            head.next.next=head;
            head.next= null;
            return newHead;
        }
    }

    static Node reverse(Node head) {
        Node p = head;
        Node pre = null;
        while(p!=null){
            Node temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
