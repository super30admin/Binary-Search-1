/*MyHashSet Implementation
Runtime is O(logn)
Space complexity is O(1). No additional space is used
The program took a long time to give the answer(7s) 
Stats from leetcode - Is this increase because of using recursion?
Runtime: 7 ms, faster than 6.07% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38.3 MB, less than 61.65% of Java online submissions for Search in Rotated Sorted Array.
 
*/

class Solution {
    public int search(int[] nums, int target) {
		int n = nums.length;
		int result = binarySearch(nums, 0, n - 1, target);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
        return result;
    }
    
    public int binarySearch(int arr[], int l, int r, int x) {
		int m = l + (r-l) / 2;
		if (x == arr[m])
			return m;
		if (l == r)
			return -1;

		if (arr[l]<=arr[m])
        {
            if (x < arr[m] && x >= arr[l])
            { 
               return binarySearch(arr, l, m-1, x);
            }
            {
                return binarySearch(arr, m+1, r, x);
            }
        }
			
		else {  
            
			if (x > arr[m] && x <= arr[r])
            { 
               return binarySearch(arr, m+1, r, x);
            }
            {
                return binarySearch(arr, l, m-1, x);
            }
        }
	}
}