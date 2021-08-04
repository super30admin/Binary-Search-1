//Time Complexity - O(log n)
//Space Complexity - O(1)
class Solution {
    public int search(int[] nums, int target) {
        //not going to be sorted at mid point always 
        //how can we find out which half is sorted - compare mid element with neighbors 
        //if target is greater than nums[low] and less than mid - then we move to left half
        //else we search in the other half 
        
        if (nums.length == 0)
        {
            return -1;
        }
        int low = 0, high = nums.length-1;
        while (low<=high){
            int mid = low+(high-low)/2; //avoiding integer overflow
            if (target==nums[mid]){ return mid;}
            else if (nums[low]<= nums[mid]){
                if (target >= nums[low] && target<nums[mid]){
                    high = mid-1;
                }
                else {
                    low=mid+1;
                }       
            }
            else {
                if (target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }  
            }  
        }
        return -1;
    }
                                       
}