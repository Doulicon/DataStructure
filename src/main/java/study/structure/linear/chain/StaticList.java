package study.structure.linear.chain;

/**
 * @author fengyongquan
 * @description 静态链表，专门为没有指针或不能通过对象引用的程序语言设计，可以学习一下其中的思想
 * @date 2020/7/14
 */
public class StaticList<T> {

    /**
     * 静态链表特点：数组最后一个元素的cur用来存放第一个插入元素的下标，相当于头结点（不一定用最后一个）
     * 数组第一个元素的cur用来存备用链表节点的下标
     * 末尾节点的下一个位置数据为空，则cur为0
     */

    /**定义*/
    SNode<T>[] node;
    private static final int  MAX_SIZE = 16;
    private int length;

    /**
     * 初始化静态链表
     */
    public StaticList(){
        node = new SNode[MAX_SIZE];
        //
        for(int i=0;i<MAX_SIZE-1;i++){
            //开辟每个数组空间，并给他们游标赋值
            node[i] = new SNode<T>(null,i+1);
        }
        //数组最后一个元素的cur用来存放第一个插入元素的下标，相当于头结点
        node[MAX_SIZE-1].setCur(0);
        this.length = 0;
    }
    /**获取实际长度*/
    public int getLength(){
        return this.length;
    }

    /**
    *判断备用链表是否为空
     */
    public boolean isFull(){
        return this.length == MAX_SIZE;
    }
    /** 判断使用数组是否为空*/
    public boolean isEmpty() {
        return length == 0;
    }


    /**新增*/
    public boolean add(T data){
        //判断是否有空间剩余
        if(isFull()){
            return false;
        }
        //根据第一个元素的cur获取备用链表的下标；
        int index = node[0].getCur();
        node[0].setCur(node[index].getCur());
        //插入数据，定义游标
        node[index].setCur(0);
        node[index].setData(data);
        //长度加一
        length++;
        return true;
    }

    /**插入*/
    public boolean insert(T data,int index){

        //判断是否为空
        //获取头结点
        int k = MAX_SIZE - 1;
        //获取备用链表的下标
        int newNodeIndex = node[0].getCur();
        //数据赋值
        node[newNodeIndex].setData(data);
        //重新定义备用列表的下标
        if(node[0].getCur()!=0){
            node[0].setCur(node[newNodeIndex].getCur());
        }
        //循环链表，到索引位置，然后插入操作
        for(int i=0;i<index-1;i++){
            //从头结点开始循环，知道找到节点位置
            k = node[k].getCur();
        }
        node[newNodeIndex].setCur(node[k].getCur());
        node[k].setCur(newNodeIndex);
        return true;
    }

    /**根据索引删除*/
    public boolean delete(int index){
        if(isEmpty()){
            return false;
        }
        //获取头结点
        int k = MAX_SIZE-1;
        //循环，找到数据所在位置，删除
        for(int i=0;i<index-1;i++){
            k = node[k].getCur();
        }
        int deleteIndex = node[k+1].getCur();
        //将待删除的元素的指针赋值给其前一个元素
        node[k].setCur(node[deleteIndex].getCur());
        //设置备用下标
        node[deleteIndex].setCur(node[0].getCur());
        node[deleteIndex].setData(null);
        node[0].setCur(deleteIndex);
        length--;
        return true;
    }

    /**删除指定数据*/
    public boolean deleteData(T data){
        if(isEmpty()){
            return false;
        }
        //获取头结点
        int k = MAX_SIZE-1;
        //遍历整个链表，找到数据所在位置，删除
        while(k!=0){
            if(node[node[k].getCur()].getData() == data){
                int deleteIndex = node[k].getCur();
                node[deleteIndex].setCur(node[0].getCur());
                node[0].setCur(deleteIndex);
                node[deleteIndex].setData(null);
                length--;
            }
            k = node[k].getCur();
        }
        return true;
    }

    //删除所有
    //打印




}
