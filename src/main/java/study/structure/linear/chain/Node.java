package study.structure.linear.chain;

/**
 * @author fengyongquan
 * @description
 * @date 2020/7/6
 */
public class Node {
    private Node next = null;
    Object data;
    public Node(Object data){
        this.data= data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
