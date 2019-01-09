package shuanfa;

/**
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，
 * 请编写二分查找的算法，在数组中查找指定元素。
 *
 */
public class Dichotomy {

    private static int  getPos(int[] array, int key){
        int left = 0;
        int mid=0;
        int right = array.length - 1;
        while (left<=right){
             mid = (left+right)/2;
            if (array[mid]>key){
              right =mid;
            }else if (array[mid]<key){
                left=mid;
            }else {
                 break;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
    }
}
