// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
1. Find the element where the rotation has happened  by using binary search.
2. You can do binary search where you take the middle element and compare if the next element is bigger or not
3. If not then see if the last element is larger than the smaller number of elements
4. If yes the go left or else go right
*/

class Solution {
    public int search(int[] nums, int target) {
        return findElement(nums, nums.length, target);
        
    }
    
    public int findElement(int[] arr, int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);
 
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }
    
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;
 
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }
    
    public static int findPivot(int arr[], int low, int high)
    {
        if (high < low)
            return -1;
        if (high == low)
            return low;
 
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }
}