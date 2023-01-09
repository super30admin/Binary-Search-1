// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: Since we dont know the end of the array we cannot place the high pointer at the end of the array like a normal binary search.
// So we start low and high pointer at 0 and 1 respectively. We move the high pointer at 2x and move the high and low pointer
// based on the mid until we find the target similar to the normal binary search

class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        
        while(reader.get(high)< target){ //O(logN) binary operation
            low=high;
            high=2*high;
        }
        
        while(low<=high){
            int mid= low + (high-low)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        
    }
}