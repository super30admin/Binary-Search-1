// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Observing either left side or right side array is sorted, I would divide the array with the help of mid and check
// whether right is sorted or left. Once I know the sorted side, I can check whether target lies in the sorted side
// (either left or right). If target doesn't lie in sorted side, I check if target lies in the other side.


public class RotatedArraySearch {

    public int search(int[] arr, int target) {
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 5;

        int index = binarySearchIterative(arr, target);
        System.out.println(target + "is present at index " + index);

        target = 3;
        index = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println(target + "is present at index " + index);
        return index;
    }

    int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (arr[mid] <= arr[high]) {
            if (arr[mid] < target && target <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } else {
            if (arr[low] <= target && target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return binarySearchRecursive(arr, target, low, high);

    }


    int binarySearchIterative(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) {
                return mid;
            }

            if (arr[mid] <= arr[high]) {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }


        }
        return -1;
    }
}
