class Solution {
    public int search(int[] nums, int target) {
        // if target == nums[mid] return mid
        // l = 0 , r = nums.length - 1 , if nums[l] < mid it means left side is sorted
        // compare nums[l] with target , if nums[l] > target  , then l = mid + 1
        // if nums[l] < target && target > nums[mid] then l = mid + 1 ;
        // else if nums[l] < target && target < nums[mid] then r = mid - 1


        // l = 0 , r = nums.length - 1 , if nums[l] > mid it means right side is sorted
        // if target == nums[mid] return mid
        // compare nums[r] with target , if nums[r] > target && nums[mid] < target then l = mid + 1
        // if nums[r] > target && nums[mid] > target  then r = mid - 1
        // if nums[r] < target then r = mid - 1

        // return - 1


        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        while( l <= r ){

            mid = l + ( r - l)/2;

            if( target == nums[mid] ){
                return mid;
            }

            else if( nums[l] <= nums[mid] ){ // at least left side sorted

                if( nums[mid] > target && nums[l] <= target ) {
                    r = mid - 1;
                }
                else { // it means it's on right side of mid
                    l = mid + 1;
                }

            }
            else { // right side is sorted
                if(  nums[mid] < target &&  target <= nums[r] ){
                    l = mid + 1;

                }
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }
}