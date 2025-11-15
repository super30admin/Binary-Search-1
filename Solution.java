class Solution {
    public int search(int[] nums, int target) {
        int low =0;
        int high= nums.length-1;
        int mid;
        while(low<high){
            mid=low+ (high-low)/2;
            if(nums[mid]==target) return mid;

            else if(nums[low]<nums[mid]){
                //leftsorted
                if(nums[low]<=target&&nums[mid]>target){
                    high=mid;
                }else{
                    low=mid+1;
                }

            } else{
                //rightSorted
                if(nums[mid]<target&&nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid;
                }
            }


        }
        if(low==high && nums[low]==target){
            return low;
        }
        return -1;

    }
}