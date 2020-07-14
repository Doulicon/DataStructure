package study.sort;

/**
 * @author fengyongquan
 * @description 希尔排序
 * @date 2020/7/2
 */
public class ShellSort {

    static public int[] shellSort(int [] arr){

        //分组
        int length = arr.length;
        int gap = length/2;

        //临时变量
        int temp;
        //分组后排序,直到增量为1
        for(int i = gap;i>0;i/=2){
            for(int j=i;j<length;j++){
                //组内排序（插入排序）
                int insert = arr[j];
                int k;
                for( k=j-i;k>=0&&insert<arr[k];k-=i){
                        arr[k+i] = arr[k];
                }
                arr[k+i] = insert;
            }
        }

        return arr;
    }

    //插入排序

    public static void main(String[] args) {
        int [] arr = {5,6,1,2,41,8,7,0,2,3};
        int []arrSort = shellSort(arr);
        for(int i=0;i<arrSort.length;i++){
            System.out.println(arrSort[i]);
        }

    }




}
