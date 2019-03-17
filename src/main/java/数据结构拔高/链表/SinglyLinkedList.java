package 数据结构拔高.链表;

/**
 * @author RickYinPeng
 * @ClassName SinglyLinkedList
 * @Description
 * @date 2019/3/11/17:47
 */
public class SinglyLinkedList {
    private Node head = null;

    static class Node {
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 判断是否是为回文
     * @return
     */
    public boolean palindrome(){
        if(head == null){
           return false;
        }else{
            System.out.println("开始执行找到中间节点");
            //慢指针
            Node p = head;
            Node q = head;
            if(p.next==null){
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next!=null && p.next.next!=null){
                p = p.next;
                q = q.next.next;
            }
            Node leftLink = null;
            Node rightLink = null;
            if(q.next==null){
                // p 一定为整个链表的中点，且节点树为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
            }else{
                //p q 均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return true;
        }
    }
    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        System.out.println("left_:"+l.value);
        System.out.println("right_:"+r.value);
        while(l != null && r != null){
            if (l.value == r.value){
                l = l.next;
                r = r.next;
                continue;
            }else{
                break;
            }

        }

        System.out.println("什么结果");
        if (l==null && r==null){
            System.out.println("什么结果");
            return true;
        }else{
            return false;
        }
    }
    /*private Node inverseLinkList_head(Node p) {
        //Head 为新建的一个头节点
        Node head = new Node(9999,null);
        //p 为原来整个链表的头节点，现在Head指向整个链表
        head.next = p;
        *//**
         * 带头节点的链表翻转等价于
         * 从第二个元素开始重新头插法建立链表
         *//*
        Node cur = p.next;
        p.next = null;
        Node next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            //System.out.println("first "+head.value);
            cur = next;
        }
        //返回左半部分的中点之前的那个节点
        //从此处开始同步向两边比较
        return head;
    }*/
    //无头结点的链表翻转
    public Node inverseLinkList(Node p){

        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.value);
        Node next= null;
        while(r !=p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

    }

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();

        Node node1 = new Node(1,new Node(2,new Node(5,new Node(2,new Node(1,null)))));
        link.head = node1;
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
