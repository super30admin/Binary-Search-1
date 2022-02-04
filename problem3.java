class Solution {
    public int search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
                return mid;
            if (nums[mid]<=nums[end]){
                //if the right side is sorted
                if(nums[mid]<target && target<=nums[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
            else{
                
                // if the left side is sorted
                if(nums[start]<=target && target<nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
        }
        return -1;
    }
}
