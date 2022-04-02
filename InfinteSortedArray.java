public class InfinteSortedArray {

    // Time Complexity : 0(log N)
    // Space Complexity : 0(1)
// Did this code successfully run on Leetcode : No. Don't have leetcode premium.
// Any problem you faced while coding this : No


    // Your code here along with comments explaining your approach: In the below code, since we don't know the length of the
    //array, we assume lower bound to be 0 and higher bound to be 1. Then we check if upper bound is less than the
    //target or not. As until and unless the upper bound is less than the target, we cannot apply binary search to determine
    //the exact index in the array. Hence to traverse faster, We change the value of low as high and keep increasing high
    //by multiple of 2 until and unless the target value is in our range. Finally we do a binary search to get the index.

    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        return BinarySearch(reader, low, high, target);
    }
    public int BinarySearch(ArrayReader reader, int high, int low, int target){
        while (low <= high){
            int mid = low + (high-low) / 2;
            if (reader.get(mid) == target){
                return mid;
            }
            else if(target < reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
