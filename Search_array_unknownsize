// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        int left =0,right =1;
        
        // Check if the target lies within the array range by doubling the array size everytime
        while(reader.get(right) < target){
            int temp = left;
            left = right+1;
            
            // doubling the array size by incrementing the right and left pointer 2 times the original position
            right = left+(right-temp)*2;
        }
        
        // Binary search operation within the identified array range (the array range determined by doubling the array size)
        while(left <= right){
            int mid = left+(right-left)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
