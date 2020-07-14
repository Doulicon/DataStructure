package study.structure.linear.chain;

/**
 * @author fengyongquan
 * @description  静态链表专用节点
 * @date 2020/7/14
 */
public class SNode<T> {

    private T data;
    private int cur;


    /**有两个节点，一个存储数据，一个游标*/
    public SNode(T data,int cur){
        this.data = data;
        this.cur = cur;
    }

    public SNode(){ }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }
}
