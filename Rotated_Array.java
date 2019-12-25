// Time Complexity : O(logN)
	// StartIndex : if - O(1), while - O(logN)
	// search : O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : finding the pattern to apply for this logic took time.

class Solution {
  int [] nums;
  int target;

  public int StartIndex(int left, int right) { // function to search the index
    
	if (nums[left] < nums[right])			   // checks if the array is not rotated 
      return 0;

    while (left <= right) {						// if the array is rotated to with respect to some pivot index
      int mid = (left + right) / 2;
      if (nums[mid] > nums[mid + 1])			// find the index by comparing left elements and right elements w.r.t pivot return the index.
        return mid + 1;
      else {
        if (nums[mid] < nums[left])				// *Binary search method* to choose the either of the halves to search
          right = mid - 1;
        else
          left = mid + 1;
      }
    }
    return 0;
  }

  public int search(int left, int right) {		// once the pivot is know apply the binary search in O(logn) times
    
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target)
        return mid;
      else {
        if (target < nums[mid])
          right = mid - 1;
        else
          left = mid + 1;
      }
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    this.nums = nums;
    this.target = target;

    int n = nums.length;

    if (n == 0)		// base case : if there are no elements return 0
      return -1;
    if (n == 1){	// if there is only 1 element, check if it matches with the target, return accordingly
		if(this.nums[0] == target){
			return 0;
		}else{
			return -1;
		}
	}

    int midIndex = StartIndex(0, n - 1);

    
    if (nums[midIndex] == target)				// if the middle element is the target, return the nums[middle]
      return midIndex;
    
    if (midIndex == 0)							// if the array is not rotated, just call the binary search method to check for the target element
      return search(0, n - 1);
    if (target < nums[0])
      return search(midIndex, n - 1);			// traverse right half of the array 
   
    return search(0, midIndex);					// traverse left half of the array for the target match
  }
}