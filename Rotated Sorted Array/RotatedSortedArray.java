// Time Complexity : O(logn)
// Space Complexity :O(mn)
class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid])
                return mid;

            //  if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;

    }

    public static void main(String args[]) 
    { 
        RotatedSortedArray rsa = new RotatedSortedArray();  
        int[]nums = {4,5,6,7,0,1,2};
        int val=rsa.search(nums, 3);
        System.out.println(val);

        
        
        
    }
}
