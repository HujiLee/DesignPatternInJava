package 设计模式实验一.ex07Adapter;

/**
 * Created by Administrator on 2016/12/24 0024.
 */

interface DataOperation {
    void sort(int[] array);
    int search(int[] array, int target);
}

class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int size = array.length;
        return BinarySearch.binarySearchRecursive(array,0,size-1,target);
    }

    private static int binarySearchRecursive(int[] arr,int low,int high,int data){
        if(high>low){
            int mid = low+(high-low)/2;
            if(arr[mid]==data){
                return mid;
            }else{
                if(arr[mid]<data){
                    return binarySearchRecursive(arr,mid+1,high,data);
                }else {
                    return binarySearchRecursive(arr,low,mid-1,data);
                }
            }
        }

        return -1;
    }
}
class QuickSort {
    public void quickSort(int[] array) {
        int size = array.length;
        quickSortRecursive(array,0,size-1);
    }

    private static void quickSortRecursive(int[] array,int low,int high){
        int pivot;
        if(high>low){
            pivot = partition(array,low,high);
            quickSortRecursive(array,low,pivot-1);
            quickSortRecursive(array,pivot+1,high);
        }
    }

    private static int partition(int[] arr,int low,int high){
        int left,right,pivot_item = arr[low];
        left = low;
        right = high;
        while (left<right){
            while (arr[left]<=pivot_item){
                left++;
            }
            while (arr[right]>pivot_item){
                right--;
            }
            if(left<right){
                swap(arr,left,right);
            }

        }
        arr[low]=arr[right];
        arr[right] = pivot_item;
        return right;

    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left]=arr[right];
        arr[right] =temp;
    }


}
class Adapter implements DataOperation {

    private QuickSort qSort;

    private BinarySearch bSearch;

    public Adapter(QuickSort qSort, BinarySearch bSearch) {
        this.qSort = qSort;
        this.bSearch = bSearch;
    }

    public void sort(int[] array) {
        qSort.quickSort(array);
    }

    public int search(int[] array, int target) {

        return bSearch.binarySearch(array,target);
    }

}



public class Main {
    public static void main(String[] args) {

    }


}
