//Search in a Rotated Sorted Array
class Problem1 {
    public int search(int[] nums, int target) {
       if(nums == null || nums.length == 0) 
           return -1; 
    
        int left = 0, right = nums.length -1;
        while(left<=right){
            int mid = left + (right-left)/2; 
            if(nums[mid]==target)
                return mid;

            else if(nums[left]<= nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target<=nums[right] && target>nums[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;  
    }
}
/*
Time Complexity : Since binary search is used to compute the index, 
the complexity is O(log(n)) 

Space Complexity : Except for the constant space used for 
left, right, mid, no other auxillary space is used. Therefore, it is O(1)

Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this : No

Your code here along with comments explaining your approach
- Mid of array is computed. If target is equal to middle element mid is 
returned as index
- Check if the target is in the sorted or unsorted portion of the array.
- If the target is in sorted portion, perform the binary search
- If the target is in unsorted portion, the algorithm continues as above until 
it finds the target in sorted portion and performs binary search.
*/

