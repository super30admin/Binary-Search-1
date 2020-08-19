// Time Complexity : O(log n)
// Space Complexity : O(n) - the space of the input
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : mentally understanding all the pieces

// Your code here along with comments explaining your approach
/*
Approach:
Find the index of the min element - minIndex - via binary search

Now you have 2 index ranges, [0..minIndex-1] and [minIndex..max].

if searchElement > [0], perform binarySearch on [0..minIndex-1]
else binarySearch on [minIndex..max]
 */
var search = function(nums, target) {
  if (nums.length === 0) return -1
  else if (nums.length === 1) return nums[0] === target ? 0 : -1;
  let minIndex = findMinIndex(nums, 0, nums.length - 1);
  if (nums[minIndex] === target) return minIndex;

  let lo = 0, hi = nums.length - 1;
  if (target < nums[0]) lo = minIndex; // search [minIndex, hi]
  else if (minIndex !== 0) hi = minIndex; // search [lo, minIndex]
  while (lo <= hi) {
    let mid = Math.floor((lo + hi)/2);

    if (target === nums[mid]) return mid;
    else if (target < nums[mid]) hi = mid - 1;
    else lo = mid + 1;
  }

  return -1;
};

function findMinIndex(arr, lo, hi) {
  if (arr[lo] < arr[hi]) return 0;

  while (lo <= hi) {
    let mid = Math.floor((lo + hi)/2);

    if (arr[mid] > arr[mid + 1]) return mid + 1;
    else {
      if (arr[mid] < arr[lo]) hi = mid - 1;
      else lo = mid + 1;
    }
  }
  return 0;
}
