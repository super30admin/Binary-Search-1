/*

TC:O(logn)
SC:O(1)

Approach : at any time atleast one part of the array is sorted

 */
class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low +(high-low)/2; //prevents integer overflow
            if(nums[mid] == target) return mid;
            if(nums[mid] < nums[high]){
                if(nums[mid] < target && target <= nums[high]){
                    low = mid +1;
                }
                else{
                    high = mid - 1;
                }

            }
            else{
                if(nums[mid] > target && target >=nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid +1;
                }

            }
        }
        return -1;

    }
}