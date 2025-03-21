// Time Complexity: O(log n) where n is the number of elements in the array
// Space Complexity: O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class RotatedSortedArray {
    public int search(int[] arr, int target) {
        int low = 0; 
        int high = arr.length - 1;
    
        while (low <= high) { 
            int mid = low + (high - low) / 2; // avoid integer overflow
            if (arr[mid] == target) return mid; // if mid is target
            if (arr[low] <= arr[mid]) { // left sorted array
                if (arr[low] <= target && arr[mid] > target) {
                    high = mid - 1; // for ex target = 6
                } else {
                    low = mid + 1; // for ex target = 1
                }
            } else { // right sorted array
                if (arr[mid] < target && arr[high] >= target) {
                    low = mid + 1;
                } else { // for example target = 0
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArray rsa = new RotatedSortedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = rsa.search(arr, target);
        System.out.println("Index of target " + target + ": " + result);

        target = 3;
        result = rsa.search(arr, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
