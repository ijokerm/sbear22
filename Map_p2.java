import java.util.HashMap;
import java.util.Map;

public class Map_p2 {
    //复制带随机指针的链表
    public static class Node{
        Node next;
        Node random;
        int val;
    }
//方法一：两个链表拆开
    static Node copy1(Node head){
        Node p=head;
        while(p!=null){
            Node q=new Node();
            q.val=p.val;

            q.next=p.next;
            p.next=q;
        }
        p=head;
        while(p!=null){
            Node q=p.next;
            if(p.random!=null){
                q.random=p.random.next;
            }else{
                q.random=null;
            }
            p.next=q;
        }
        return head;
    }
//方法2
    static Node copy2(Node head){
        Node p=head;
        Node result=null;
        Node last=null;

        Map<Node,Node>map=new HashMap<>();
        while(p!=null){
            Node q=new Node();
            q.val=p.val;
            if(result==null){
                result=q;
            }else{
                last.next=q;
            }
            last=q;
            map.put(p,q);
            p=p.next;
        }
        p=head;
        Node q=result;

        while(p!=null){
            q.random=map.get(p.random);

            p=p.next;
            q=q.next;
        }
        return result;
    }
}
