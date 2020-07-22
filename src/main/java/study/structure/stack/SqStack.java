package study.structure.stack;

import javax.activation.MailcapCommandMap;
import javax.crypto.interfaces.PBEKey;

/**
 * @author fengyongquan
 * @description
 * @date 2020/7/22
 */
public class SqStack<T> {


    private int MAXSIZE = 0;
    private int top = -1;
    private Object [] data;

    /**默认初始化栈大小*/
    SqStack(){
        this.MAXSIZE = 16;
        data = new Object[MAXSIZE];
    }

    /**自定义栈大小*/
    SqStack(int maxSize){
        this.MAXSIZE = maxSize;
        data = new Object[maxSize];
    }

    /**清空栈*/
    public boolean clearStack(){
        //重新初始化
        data = new Object[this.MAXSIZE];
        this.top = -1;
        return true;
    }

    /**判断栈是否为空*/
    public boolean stackEmpty(){
        if(this.top == -1){
            System.out.println("为空");
            return true;
        }else {
            System.out.println("不为空");
            return false;
        }
    }

    /**若非空，则返回栈顶元素*/
    public Object getTop() throws Exception {
        if(stackEmpty()){
            throw new Exception("栈为空无法获取数据");
        }
        System.out.println("栈顶元素："+data[this.top]);
        return data[this.top];
    }

    /**入栈*/
    public boolean push(T e) throws Exception {
        if(this.top == MAXSIZE-1){
            throw new Exception("栈满了");
        }
        this.top ++;
        this.data[top] = e;
        System.out.println("入栈成功："+e);
        return true;
    }
    /**出栈*/
    public Object pop() throws Exception {
        if(this.top == -1){
            throw new Exception("栈为空无法获取数据");
        }
        Object e = data[this.top];
        this.top --;
        System.out.println("出栈成功："+e);
        return e;
    }

    /**返回栈元素的个数*/
    public int getStackLength(){
        System.out.println("元素个数为："+ (this.top+1));
        return this.top+1;
    }

}

class SqStackTest {
    public static void main(String[] args) throws Exception {

        SqStack sqStack = new SqStack();

        sqStack.push(100);
        sqStack.push(101);
        sqStack.push(102);
        sqStack.getStackLength();
        sqStack.getTop();
        sqStack.getStackLength();
        sqStack.pop();
        sqStack.getStackLength();
        sqStack.getTop();
        sqStack.pop();

    }
}
