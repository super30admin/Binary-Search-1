// Time Complexity : O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        
        while(reader.get(right) != Integer.MAX_VALUE){
            right = right * 2;
        }
        return binarySearch(reader, left, right, target);
    }
    
    private int binarySearch(ArrayReader reader, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) > target){
                right = mid - 1;                
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}
