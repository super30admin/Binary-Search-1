//Time Complexity: O(logn);
//Space complexity: O(1);


ublic  class SearchInRotatedArray{
    public int search(int[] nums, int target) {

        int left =0; int right = nums.length -1;

        int mid;

        while(left <= right){
            mid = left + (right - left)/2;

            if(nums[mid] == target) return mid;

            else if(target < nums[mid]){

                if(nums[left] <= nums[mid] &&
                        target < nums[left]) left =  mid+1;

                else right  = mid-1;
            }
            else {
                if(nums[mid] <= nums[right] &&
                        target > nums[right]) right = mid-1;

                else left = mid+1;

            }

        }

        return -1;

    }
}