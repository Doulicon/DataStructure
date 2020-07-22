package study.structure.stack;

import sun.applet.Main;

/**
 * @author fengyongquan
 * @description
 * @date 2020/7/22
 */
public class LinkStack<T> {

    Node top = new Node();

    /**入栈*/
    public boolean push(T e) throws Exception {
        Node node = new Node(e);
        if (this.top!=null){
            node.setNext(this.top.getNext());
        }
        this.top.setNext(node);
        System.out.println("入栈成功："+top.getNext().data);
        return true;
    }
    /**出栈*/
    public Object pop() throws Exception {
        if(null==this.top.getNext()){
            throw new Exception("栈为空无法获取数据");
        }
        Object e = top.getNext().data;
        top.setNext(top.getNext().getNext());
        System.out.println("出栈成功："+e);
        return e;
    }

}

class LinkStackTest{

    public static void main(String[] args) throws Exception {
        LinkStack<Integer> linkStack = new LinkStack<Integer>();
        linkStack.push(100);
        linkStack.push(101);
        linkStack.pop();
        linkStack.pop();
    }


}
