// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class searchInRotated {
    public int search(int nums[], int target) {
        // 1
        int start = 0;
        int end = nums.length - 1;

        //2
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        searchInRotated obj = new searchInRotated();
        int nums[] = { 2, 3, 4, 5, 6, 7, 0, 1 };
        int target = 0;
        int index = obj.search(nums, target);

        if (index != 1)
            System.out.println("Target found at index: " + index);
        else
            System.out.println("Target not found");
    }
}