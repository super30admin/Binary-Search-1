// Time Complexity : O(log(n)), worst case can be O(n) 
// Space Complexity : log(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class BinaryNon {

    public int search(int[] nums, int target) {
        int index = -1;
        if (nums.length >= 2) {
            int pivot = -1;

            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
                    pivot = i;
                    break;
                }
            }

            if (pivot < 0) {
                pivot = nums.length - 1;
            }
            if (nums[nums.length - 1] >= target && nums[pivot] <= target) {
                index = binarySearch(nums, pivot, nums.length - 1, target);
            } else if (nums[pivot - 1] >= target && nums[0] <= target) {
                index = binarySearch(nums, 0, pivot - 1, target);
            }
        }

        else if (nums.length == 1) {
            if (nums[0] == target)
                index = 0;
            else
                index = -1;
        } else {
            index = -1;
        }
        return index;

    }

    int binarySearch(int arr[], int l, int r, int x) {
        int pivot = (l + r) / 2;
        if (arr[pivot] == x) {
            return pivot;
        } else if (arr[pivot] < x && pivot <= r) {
            if (pivot + 1 > r)
                return -1;
            else
                return binarySearch(arr, (pivot + 1), r, x);
        } else if (arr[pivot] > x && pivot <= r) {
            return binarySearch(arr, l, pivot - 1, x);
        } else
            return -1;
    }

    public static void main(String[] args) {
        BinaryNon bn = new BinaryNon();
        int[] arr = { 1, 3, 5 };
        System.out.println(bn.search(arr, 0));
        System.out.println(bn.binarySearch(arr, 0, arr.length - 1, 0));

        int[] arr2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(bn.search(arr2, 0));

    }
}
