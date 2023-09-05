/*
* TC: O(log m*n) since we are doing a binary search on the entire matrix
* SC: O(1)
* Did this code successfully run on Leetcode : Yes
* Any problem you faced while coding this: No
* Approach:
* To do a search on the whole matrix we consider the m as the no of rows and n as the number of cols
* we then consider low as the first element in the matrix and high as the last element in the matrix
* we find the mid
*
* then we do a binary search but since its a 2D matrix we have to have a way to figure out the position without flattening the array
* so to find the row and col
*   we do row = mid / n  (where n is the number of columns to find the row position)
*   col = mdi % n (as we know % helps us stay within range)
* */

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {

  if (!matrix) return false;

  const m = matrix.length;
  const n = matrix[0].length;
  let low = 0;
  let high = m * n - 1

  while (low <= high) {
    let mid = Math.floor(low + (high - low)/2); // Avoid integer overflow not possible in js though
    let row = Math.floor(mid / n);
    let col = Math.floor(mid % n);

    if (matrix[row][col] === target) {
      return true;
    } else if (target > matrix[row][col]) {
      low = mid + 1
    } else {
      high = mid -1
    }
  }

  return false;
};
