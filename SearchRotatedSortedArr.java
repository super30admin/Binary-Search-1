//Time Complexity: O (log n)
//Space Complexity: O (1)
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[low]<=nums[mid]){
                // When left subarry is sorted
                //Check if the value is present inside the range or update          accordingly
                if(nums[low]<= target && nums[mid] >target)
                    high=mid-1;
                else
                    low=mid+1;
            }else{
                //When right subarray is sorted
                System.out.println("Right Subarray");
                if(nums[mid]<target && nums[high]>=target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}
