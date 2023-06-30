// TC :  O(log n)
// SC :  O(1)
class SeacrhInARotatedSortedArray {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length -1;

        while(i <= j) {
            int mid = i + (j-i) / 2;
            if(nums[mid] == target) {
                return mid;
            } 
            // if left is sorted
            if(nums[i] <= nums[mid]) {
                if (target >= nums[i] && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            // if right is sorted
            else {
                if(target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }   
        }

        return -1;
    }
}