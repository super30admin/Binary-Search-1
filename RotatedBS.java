class RotatedBS {
    public int search(int[] nums, int target) {

        if(nums.length ==0) {
            return -1;
        }
        return  helper(nums, target, 0, nums.length-1);
    }

    private int helper(int [] nums, int target, int start, int end) {
        if(start>end) {
            return -1;
        }

        int mid = start +(end-start)/2;

        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] >= nums[start]) {
            if(target <= nums[mid]  &&  nums[start] <= target) {
                return helper(nums, target, start, mid-1);
            } else {
                return helper(nums, target, mid+1, end);
            }
        } else {
            int ans = helper(nums, target, start, mid-1);
            return ans ==-1 ? helper(nums, target, mid+1, end) : ans;
        }
    }
}