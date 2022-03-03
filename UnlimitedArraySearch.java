/*
Time Complexity : O(log Integer.MAX_VALUE) binary search worst case
Space Complexity : O(1) since we create memory when array is generated

Did this code successfully run on Leetcode :
Finished in 62 ms
ex2147483647
ex1073741822
ex536870910
ex268435454
ex134217726
ex67108862
ex33554430
ex16777214
ex8388606
ex4194302
ex2097150
ex1048574
ex524286
ex262142
ex131070
ex65534
ex32766
ex16382
ex8190
ex4094
ex2046
ex1022
ex510
ex254
ex126
ex62
ex30
4

Any problem you faced while coding this :
I couldnt code it in interative way

Your code here along with comments explaining your approach :
pivot where it is rotating pivot and then simple binary search 

The comments after sysouts were expected output and they matched.
*/
public class UnlimitedArraySearch {
    static int binarySearch(int []arr, int low, int high, int key){
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        try{
            if (key == arr[mid])
                return mid;
            if (key > arr[mid])
                return binarySearch(arr, (mid + 1), high, key);
            return binarySearch(arr, low, (mid - 1), key);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("ex"+high);
            return binarySearch(arr, low, (mid - 1), key);
        }
    }

    public static void main(String[] args) {
        int high = Integer.MAX_VALUE;
        int []array = {1, 2, 4, 5, 7, 8, 8, 9};
        System.out.println(binarySearch(array, 0, high, 7));//4
        System.out.println(binarySearch(array, 0, high, 10));//-1
    }
}
