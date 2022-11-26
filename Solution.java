// Time Complexity : O(logmn)
// Space Complexity : O(1)
/*
 * the idea is to move the low and high pointers until we have target
 * in range. Then perform binary search between low and high.
 */

interface ArrayReader {
    public int get(int index);
}

class Solution{
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        int mid = low + (high-low)/2;
        if (reader.get(mid) == target) return mid;
        while(high > low){
            if (reader.get(mid) > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}