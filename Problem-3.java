// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target) return 0;
        
        int left=0; int right=1;
        while(reader.get(right)<target){
            left=right;
            right = right*2;
        }
        
        while(left<=right){
            int mid = left + (right-left)/2;
            if(reader.get(mid)==target)
                return mid;
            if(reader.get(mid)>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}