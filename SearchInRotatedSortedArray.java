public class SearchInRotatedSortedArray {
    /*
    As this array might be sorted and this problem requires log n complexity, we have to use bunary search. to achieve this - we need to modify this binary search algorithm and find mid. and then move left and right pointers till we grt desired answer.
    */
    /*
    Time : O(log n)
    Space :O(1)
    */
    public static int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //if left aray is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            }

            //right array is sorted
            else {
                if (nums[right] >= target && nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
