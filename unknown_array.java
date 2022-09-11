// Time Complexity : O(log)n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == Integer.MAX_VALUE) return -1;
        
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low =high;
            high = high*2;
        }
        
        return binarySearch(reader,low,high,target);
        
    }
    
    private int binarySearch(ArrayReader reader, int low, int high, int target){
        
        
        while(low <= high){
            int mid = low + (high -low)/2;
            if(target ==  reader.get(mid)) return mid;
            if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}