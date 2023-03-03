//Time Complexity:O(log n)
//Space Complexity: O(1)
// executed on leetcode: yes 
// Searching element in rotated sorted array using binary search. first searched the element in sorted side if not found moved to the another side 
class Solution {
    public int search(int[] nums, int target) {

        if(nums==null || nums.length==0)
        return -1 ;

        int low = 0;
        int high= nums.length -1 ;
         
         while(low <= high){
             int mid = low + (high-low)/2;
             if(nums[mid]== target)
             return mid;
             if(nums[low] <= nums[mid] )
             {
                 // left sorted 
                 if(nums[low]<= target && nums[mid]> target)
                  high = mid-1;
                  else low = mid+1;

             }else{
                 //right sorted 
                 if(nums[mid]<target && nums[high] >= target)
                 low = mid+1;
                 else high = mid-1 ;
             }
         }
       return -1; 
    }
}
