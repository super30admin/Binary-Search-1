/**
 * Time Complexity: O(LogN)
 * Space Complexity; O(1)
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int[] indices = indexSearch(reader, target);
        int low = indices[0];
        int high = indices[1];
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] indexSearch(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        int[] arr = new int[2];
        while(reader.get(high) < target){
            low = high + 1;
            high = low * 2;
        }
        arr[0] = low;
        arr[1] = high;
        return arr;
    }
}