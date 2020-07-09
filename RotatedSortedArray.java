// Time Complexity : O(log n), where n is the size of the array 
// Space Complexity : O(1) // since it's a finite sized array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Approach 1: Iterative binary search
// 1. Check if the array is left-sorted or right-sorted.
// 2. If it is either one of them, then check if the target element is present in either half.
// 3. else check the other half.
// 4. return if found.


class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = left + (right-left) /2 ;
            if(nums[mid] == target) 
                return mid;
            //If the array is left-sorted
            else if(nums[mid] >= nums[left])
            {
                if( target >= nums[left] && target < nums[mid] )
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else //right-sorted
            {
                if(target <= nums[right] && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }  
}

// Approach 2: 
// 1. Find the pivot element. Pivot element is the one where there's a deflection. Pivot basically divides the array into 2 parts.d
// 2. Now, compare pivot with the target value.
// 3. Perform binary search in the respective half.

class Solution {
    int [] nums;
    int target;
 
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
        return -1;
        if (n == 1)
        return this.nums[0] == target ? 0 : -1;

        int pivotPosition = getPivotPostion(0, n - 1);

        // if target is the smallest element
        if (nums[pivotPosition] == target)
        return pivotPosition;
        // if array is not rotated, search in the entire array
        if (pivotPosition == 0)
        return binarySearch(0, n - 1);
        if (target < nums[0])
        // search in the right side
        return binarySearch(pivotPosition, n - 1);
        // search in the left side
        return binarySearch(0, pivotPosition);
  }  


  public int getPivotPosition(int left, int right) {
    if (nums[left] < nums[right])
      return 0; // array is sorted, and not rotated

    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[mid + 1])
        return mid + 1;
      else {
        if (nums[mid] < nums[left])
          right = mid - 1;
        else
          left = mid + 1;
      }
    }
    return 0;
  }

  public int binarySearch(int left, int right) {
    /*
    Binary search
    */
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

  
}