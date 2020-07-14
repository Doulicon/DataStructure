package study.sort;

/**
 * @author fengyongquan
 * @description 选择排序法
 *  空间复杂度O(1)
 *  时间复杂度O（n*n）
 * @date 2020/6/29
 */
public class SelectSort {

    static public int[] selectSort(int[] arr){

        int temp = 0;
        int length = arr.length;
        for(int i=0;i<length;i++){
            int minIndex = i;
            for(int j = i;j<length;j++){
                //找最小元素的下标
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {5,6,1,2,41,8,7,0,2,3};
        int []arrSort = selectSort(arr);
        for(int i=0;i<arrSort.length;i++){
            System.out.println(arrSort[i]);
        }

    }

}
