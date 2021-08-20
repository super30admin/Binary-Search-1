//Search in a Sorted Array of Unknown Size
//Time complexity: O(log n)
class Solution {
    public int search(ArrayReader reader, int target) {
        //initalize low at 0 index
        int low = 0;
        //initalize high at index 1
        int high = 1;
        //We will keep shifting the low and the high pointer until the value at index[high] is less than target
        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        //use the binary search tree approach to search the element.
        while(low <= high) {
            //get the mid index using low and high
            int mid = low + (high - low)/2;
            //if the element at mid is equal to target, return the mid(index of element at mid)
            if(reader.get(mid) == target) {
                return mid;
            }
            //if the element at mid is less than the target, means the target is in the right subarray of the mid
            //ie. right sub tree 
            else if(reader.get(mid) < target) {
                low = mid + 1;
            }
            //if the element at mid is greater than the target, means the target is in the left subarray of the mid
            //ie. left sub tree 
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}