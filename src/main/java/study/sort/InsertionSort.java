package study.sort;

/**
 * @author fengyongquan
 * @description 插入排序
 * 比较前面已经排序好的集合，遍历并插入到正确的位置
 * 空间复杂度O(1)
 * 时间复杂度O（n*n）
 * @date 2020/6/29
 */
public class InsertionSort {

    static int [] insertionSort(int []arr){

        int temp = 0;
        int length = arr.length;
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0&&arr[j+1]<arr[j];j--){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
            }
        }
        return arr;
    }

    //因为是比较已经是排序好的集合，但是没有好好的利用，所以可以使用二分法来进行插入
    static int [] insertionSort2(int []arr){

        int temp = 0;
        int length = arr.length;

        for(int i=1;i<length;i++){
            temp = arr[i];
            int index = findInsertIndex(arr,0,i-1,arr[i]);
            for(int j=i;j>index;j--){
                arr[j] = arr[j-1];
            }
            arr[index] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {5,6,1,2,41,8,7,0,2,3};
        int []arrSort = insertionSort2(arr);
        for(int i=0;i<arrSort.length;i++){
            System.out.println(arrSort[i]);
        }

    }

    /**
     * @param arr 操作数组
     * @param l 左标
     * @param r 右标
     * @param value 比较值
     * @return 插入位置
     */
    public static int findInsertIndex(int []arr,int l,int r,int value){
        while(l<=r){
            int mid = (l+r)/2;
            if(value>arr[mid]){
                l=mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
