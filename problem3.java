// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        while(reader.get(high) < target){
            low=high;
            high=high*2;
        }
        return binarySearch(reader, target, low, high);
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target)
                return mid;
            else if(reader.get(mid)>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return -1;
    }
}