// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  // Base Case
  if (matrix === null || matrix.length === 0) {
    return false;
  }

  // Get low and high in matrix
  var m = matrix.length;
  var n = matrix[0].length;
  var low = 0;
  var high = m * n - 1;

  //Binary search
  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    var row = Math.floor(mid / n);
    var col = Math.floor(mid % n);
    var midEl = matrix[row][col];
    if (midEl === target) {
      return true;
    }
    //Check if item is in left side
    if (target < midEl) {
      high = mid - 1;
    } else {
      // Item might exists in right side
      low = mid + 1;
    }
  }
  return false;
};
