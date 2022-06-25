// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  if (!matrix || !matrix.length) return false;

  const rows = matrix.length;
  const columns = matrix[0].length;

  let low = 0;
  let high = rows * columns - 1;

  while (low <= high) {
    mid = Math.floor(low + (high - low) / 2);
    // calculating the positin of mid in 2D array
    const row = Math.floor(mid / columns);
    const column = Math.floor(mid % columns);

    // finding if the element is present at the calculated position in 2D array
    const matrix_element = matrix[row][column];
    if (matrix_element === target) return true;
    else if (target < matrix_element) {
      // when target is less than matrix element do left binary search
      high = mid - 1;
    } else {
      // when target is greater than matrix element do right binary search
      low = mid + 1;
    }
  }
  return false;
};
