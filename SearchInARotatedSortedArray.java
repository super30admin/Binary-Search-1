// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: In a rotated sorted array, one of the part will always be sorted. We check if the low or the high elements are smaller 
// or larger than mid and based on that we move our low and high pointers to find the target.
class Solution {
    public int search(int[] arr, int target) {
        
        if(arr==null || arr.length==0) return -1;
        
        int low=0, high=arr.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[low]<=arr[mid]){
                //left side sorted
                
                // > and not >= because we already checked the condition arr[mid]==target
                if(arr[low]<=target && arr[mid] > target){ 
                    high=mid-1;
                    
                } else {
                    low=mid+1;
                }
            }
            else{
                if(arr[mid]< target && arr[high]>=target){
                    low=mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
        
    }
}