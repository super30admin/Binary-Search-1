class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int mid = 0;

        while(i<=j) {

            mid = i+(j-i)/2;

            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]>=nums[i]) {
                if(target>=nums[i] && target<=nums[mid]) {
                    j = mid - 1;
                }else {
                    i = mid + 1;
                }
            }else {
                if(target<=nums[j] && target>=nums[mid]) {
                    i = mid + 1;
                }else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }
}