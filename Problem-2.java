class Solution {
    public int search(int[] nums, int target) {
        //Time Complexity:-O(logn);//Because we using the Binary search to solve the problem
        //Space Complexity:-O(1);//Because we are not using any extra memory except auxiliary memory
        int low=0;
        int high=nums.length-1;
        
        if(nums == null || nums.length == 0) return -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[low]<=nums[mid]){//First we need to get to know which side is sorted
                //left side sorted
                if(nums[low]<=target && target<=nums[mid]){
                        high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            //if the left side is sorted and the target lies in right side then we need to search in the right side
            //once we find the mid in the right side the it will become like the normal problem where the one side will
            //be sorted and another side is not
            else{
                if(nums[high]>=target && target>=nums[mid]){
                        low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }
}