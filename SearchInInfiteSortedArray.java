
//Time - O(logN)
//Space - O(1)
/*
Expand the search from low=0, high =1 by doubling the high value
*/
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; int high = 1;
        while(reader.get(high) < target){
            low = high; high = 2 * high;
        }
        return binarySearch(reader, low, high, target);
    }
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) high = mid-1;
            else low = mid + 1;
        }
        return -1;
    }
}