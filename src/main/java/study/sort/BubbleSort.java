package study.sort;

/**
 * @author fengyongquan
 * @description 冒泡排序
 * 空间复杂度O(1)
 * 时间复杂度O（n*n）
 * @date 2020/6/29
 */
public class BubbleSort {

    static public int [] bubbleSort(int []arr){

        int temp = 0;
        int length = arr.length;
        for(int i=0;i<length-1;i++){
            //如果已经排序则提前结束（性能优化）
            boolean isChange = false;
            for(int j=0;j<length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isChange = true;
                }
            }
            if(!isChange){
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int [] arr = {5,6,1,2,41,8,7,0,2,3};

        int []arrSort = bubbleSort(arr);
        for(int i=0;i<arrSort.length;i++){
            System.out.println(arrSort[i]);
        }


    }


}
