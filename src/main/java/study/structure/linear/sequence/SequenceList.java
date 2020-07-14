package study.structure.linear.sequence;

/**
 * @author fengyongquan
 * @description 线性表顺序存储结构
 * @date 2020/7/3
 */
public class SequenceList<T> {

    /**下标*/
    private int size = 0;
    /**线性表空间大小*/
    private int maxLength = 0;
    /**定义数组*/
    private Object[] arr;

    /**默认初始化大小20*/
    SequenceList(){
        //默认大小
        this.maxLength = 16;
        arr = new Object[maxLength];
    }
    /**用户自定义初始化大小*/
    SequenceList(int maxLength){
        this.maxLength = maxLength;
        arr = new Object[maxLength];
    }

    /**以插入一个元素的方式初始化*/
    SequenceList(T element){
        //调用无惨构造方法
        this();
        arr[0] = element;
        size++;
    }

    /**以插入一个元素的方式,并且自定义大小的方式初始化*/
    SequenceList(T element,int initSize){
        //调用无惨构造方法
        this.maxLength = 1;
        //最小的2的n次方
        while (this.maxLength<initSize){
            this.maxLength<<=1;
        }
        arr = new Object[maxLength];
        arr[0] = element;
        size++;

    }

    /**获取长度*/
    public int getSize(){
        return this.size;
    }

    /**
     * 插入
     * @param i 插入索引
     * @param element 插入元素
     */
    public void ListInsert(int i,T element) throws Exception {

        //TODO应该补充一些判断
        //线性表已满
        if(this.size==this.maxLength){
            throw new Exception("线性表满了");
        }
        //i不在范围之内
        if(i<1||i>this.size+1){
            throw new Exception("i不在范围之内");
        }

        //元素后退一位
        if(i<=this.size){
            for(int j=this.size-1;j>i-1;j--){
                arr[j+1] = arr[j];
            }
        }
        arr[i-1] = element;
        size++;
    }


    /**
     * 删除
     * @param i
     */
    public void ListDelete(int i){

        //TODO应该补充一些判断

        //元素前进一位
        for(int j=i-1;j<this.size-1;j++){
            arr[j] = arr[j+1];
        }
        size--;
    }

    /**按索引查询*/
    public Object getElement(int i){
        return arr[i];
    }

    /**遍历*/
    public void getAllElement(){
        for(int j=0;j<this.size;j++){
            System.out.println(arr[j]);
        }
    }

    //TODO 清空连表

}

class ListTest{

    public static void main(String[] args) throws Exception {
        SequenceList<Integer> list = new SequenceList<Integer>(5,30);

        System.out.println(list.getSize());
        System.out.println("-------");
        list.ListInsert(2,4);
        list.ListInsert(3,5);
        list.ListInsert(4,6);
        list.ListInsert(3,8);
        System.out.println(list.getSize());
        System.out.println("-------");
        list.getAllElement();
        System.out.println("-------");
        System.out.println(list.getElement(2));
        list.ListDelete(2);
        System.out.println("-------");
        list.getAllElement();


    }



}
