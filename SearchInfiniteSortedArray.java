/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==Integer.MAX_VALUE)
            return -1;
        int slow = 0;
        int fast = 1;
        while(reader.get(fast)!=Integer.MAX_VALUE && reader.get(fast)<target){
            slow = fast;
            fast = fast * 2;
        }
        int low = slow;
        int high = fast;
        int mid,midVal;
        while(low<=high){
            mid = low + (high - low)/2;
            midVal = reader.get(mid);
            if(midVal == Integer.MAX_VALUE)
                high = mid - 1;
            else if(midVal == target)
                return mid;
            else if(midVal < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;

    }
}