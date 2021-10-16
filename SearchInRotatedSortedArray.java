class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = low + (high - low)/2;

            if(nums[mid]== target)
                return mid;
            else if(nums[mid]>nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        if(target>nums[nums.length-1]){
            high=low;
            low=0;
        }
        else
            high=nums.length-1;
        while(low<=high){
            mid=(low+high)/2;

            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
}