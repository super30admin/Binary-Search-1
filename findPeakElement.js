/**
 * 
  Intution is to use binary search as the requirement is to write an algorithm which completes in O(log n)
  I am moving my pointers towards the peak always, if the peak resides on the left iam moving my right pointer towards mid 
  otherwise left pointer to the right.
  Time complexity : O(log n)
  Space Complexity: O(1) as i am not using any extra space other than left and right pointers.
 */
var findPeakElement = function (nums) {
    let left = 0, right = nums.length - 1;
    while(left < right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
};

