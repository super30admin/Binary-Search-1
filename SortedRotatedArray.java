//Time Complexity: O(log(n))
// Space Complexity: O(1)

// Did the code run on leetcode: Yes

class SortedRotatedArray {
    public int search(int[] nums, int target) {

        int low = 0;
        int n = nums.length;
        int high = nums.length -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        // Finding the index where minimum number exists. This index is considered as a pivot
        int minNumIndex = findMinIndex(nums, low, high, n);
        int result;
        // Binary Search is applied to the left part of the minNumIndex
        result = binarySearch(nums, 0, minNumIndex - 1, target);
        if(result != -1)
            return result;
        // If the element is not found on the left side then BinarySearch is applied on the right side of the minNumIndex
        else{
            result = binarySearch(nums, minNumIndex, n-1, target);
            if(result != -1)
                return result;
        }
        return -1;

    }

    // BinarySearch to find the minimum number in the array
    private int findMinIndex(int[] nums, int low, int high, int n){

        while(low <= high){
            int mid = low + (high - low)/2;
            int next = (mid + 1) % n;
            int prev = ( mid - 1 + n ) % n;
            // Minimum number is such that it is less that its prev element and less than its next element
            if(nums[mid] < nums[prev] && nums[mid] < nums[next]) return mid;
            else if(nums[mid] < nums[high]){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) h = mid -1;
            else l = mid + 1;
        }
        return -1;
    }
}