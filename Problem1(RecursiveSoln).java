/*Recursive Algorithm:
    1. Check if the mid element is equal to the target. If yes return mid index.
    2. Else check if the left handside from the mid element is sorted, Inside this condition check if the target is in between low and mid index, If yes search for the element in left side of array from the mid by updating high pointer to mid-1, If no search for the element in the right side of the array by updating the low pointer to low+1.
    3. Else we know the right side of the array from mid is sorted, Inside this condition check if the target is in between mid+1 and high inde, If yes search for the element in right side of array from the mid by updating low pointer to mid+1, If no search for the element in the left side of the array by updating the high pointer to mid-1.
    
    Time Complexity : O(log(n))
    Space Complexity: O(1);  //As no extra space
    
    Did the code run successfully on leetcode: Yes
    

*/


class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0 )
            return -1;
        
        return searchBT(nums, 0, nums.length-1, target);
        
    }
    
    private int searchBT(int[] nums, int low, int high, int target){
        //Base case
        if(low< 0 || low>=nums.length || high<0 || high>=nums.length)
            return -1;
        if(low<=high){
        int mid = low +(high-low)/2 ;
        
        if(nums[mid]==target)
            return mid;
        else if(nums[low]<=nums[mid]){  //Left side sorted
            if(nums[low]<=target && nums[mid]>=target)
                 high = mid-1;
            else
                low = mid+1;
        } 
        else{ //Right side sorted
            if(nums[mid]<=target && nums[high]>=target)
                low = mid+1;
            else
                high = mid-1;
        } 
        
        }
        else{
            return -1;
        }
        
        return searchBT(nums, low, high, target);
    }
}