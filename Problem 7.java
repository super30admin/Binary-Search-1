// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : needed to refer to lecture to see how to double the search space but remembered the logic

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        
        return binarySearch(reader, low, high, target);
    }
    
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
