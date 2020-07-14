package study.structure.linear.chain;

import sun.applet.Main;
import sun.security.util.Length;

/**
 * @author fengyongquan
 * @description 单链表
 * @date 2020/7/6
 */
public class LinkList {

    //定义表头
    Node head = null;

    /**添加一个元素*/
    public void addNode(Object data){
        Node node = new Node(data);

        if(head==null){
            head = node;
            return;
        }

        Node temp = this.head;
        while (temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(node);

    }

    /**单链表读取（查询第k个元素）*/
    public Node getElem(int k) throws Exception {
        if(k<1||k>getLength()){
            throw new Exception("索引不在范围内");
        }
        Node temp = this.head;
        for(int i=0;i<k-1;i++){
            temp = temp.getNext();
        }
        return temp;
    }

    /**获取表的长度*/
    public int getLength(){
        int length = 0;
        Node temp = this.head;
        while (temp!=null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }

    /**插入*/

    public void insertDate(int k,Object date) throws Exception {
        if(k<1||k>getLength()){
            throw new Exception("索引不在范围内");
        }

        Node newNode = new Node(date);
        Node temp = this.head;

        for(int i=1;i<k-1;i++){
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }


    /**删除*/
    public void deleteDate(int k) throws Exception {

        if(k<1||k>getLength()){
            throw new Exception("索引不在范围内");
        }
        //删除头结点
        if(k == 1){
            head = head.getNext();
            return;
        }
        Node temp = this.head;
        for(int i=1;i<k-1;i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }

    /**链表翻转*/
    /**返回链表的最后一个结点*/

    /**
     * 打印结点
     */
    public void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.data+" ");
            curNode = curNode.getNext();
        }
        System.out.println();
    }

}

    class LinkListTest{
        public static void main(String[] args) throws Exception {
            LinkList linkList = new LinkList();
            linkList.addNode(5);
            linkList.addNode(6);
            linkList.addNode(4);
            System.out.println(linkList.getLength());
            System.out.println("---------------");
            linkList.printLink();
            System.out.println("---------------");
            System.out.println(linkList.getElem(2).data);
            System.out.println("---------------");
            linkList.insertDate(3,5);
            linkList.printLink();
            System.out.println("---------------");
            linkList.deleteDate(3);
            linkList.printLink();
        }
    }
