class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;

        while(low<=high){//low should be less than high
            int mid=low+(high-low)/2;//to avaid integer overflow in java
            if(nums[mid]==target)//mid indexed value =target
                return mid;
            if(nums[low]<=nums[mid]){//left portion
                if(target>=nums[low] && target<nums[mid])
                    high=mid -1;
                else
                    low=mid+1;
            }
            else{//right portion
                if(target>nums[mid] && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}

//Time Complexity: O(logn)
//Space Complexity: O(1)
