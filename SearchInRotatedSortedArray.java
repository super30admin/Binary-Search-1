//Time Complexity - O(log n)
//Space Complexity - O(1)
//Ran in Leetcode - Yes

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle =0;

        while(left<=right){
            middle = left + (right-left)/2;
            if(nums[middle] == target)
                return middle;
            if(left<=middle)
            {
                //sorted
                if (target >= nums[left] && target < nums[middle])
                    right = middle-1;
                else
                    left = middle+1;
            }
            else
            {
               if (target > nums[middle] && target <= nums[right])
                    left = middle+1;
                else
                    right = middle-1;
            }
        }
        return -1;
    }
}